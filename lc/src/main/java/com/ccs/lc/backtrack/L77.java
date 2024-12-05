package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/11/28 13:43
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 */
public class L77 {

    private  List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();
        combine(list,1,n,k);
        return resList;
    }

    public void combine(List<Integer> list,int cur,int n,int k){

        if(list.size()+(n-cur+1) < k){
            return;
        }
        if(list.size() >= k){
            resList.add(new ArrayList<>(list));
            return;
        }
        ArrayList<Integer> nextList = new ArrayList<>(list);

        nextList.add(cur);
        combine(nextList,cur+1,n,k);

        nextList.remove(nextList.size()-1);
        combine(nextList,cur+1,n,k);
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new L77().combine(4, 3);
        System.out.println(combine);
    }
}
