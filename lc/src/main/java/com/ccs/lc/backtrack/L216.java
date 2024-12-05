package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/11/28 21:40
 */
public class L216 {

    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        compute(temp,k,n,0,1);
        return resList;
    }

    public void compute(List<Integer> list,int k,int n,int count,int start){

        if(count > n){
            return;
        }
        if(count == n){
            resList.add(new ArrayList<>(list));
            return;
        }
        if(count < n){
            if(list.size() >= k){
                return;
            }
        }

        for(int i=start;i<=9;i++){
            list.add(i);
            compute(list,k,n,count+i,i);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new L216().combinationSum3(3, 10);
        System.out.println(lists);
    }
}
