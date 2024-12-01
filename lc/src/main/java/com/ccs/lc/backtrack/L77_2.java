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
public class L77_2 {

    private  List<List<Integer>> resList = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        backtracking(1,n,k);
        return resList;
    }

    public void backtracking(int cur,int n,int k){
        if(temp.size()==k){
            resList.add(new ArrayList<>(temp));
            return;
        }
        for(int i=cur;i<=(n-k)+temp.size()+1;i++){
            temp.add(i);
            backtracking(i+1,n,k);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new L77_2().combine(4, 3);
        System.out.println(combine);
    }
}
