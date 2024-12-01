package com.ccs.lc.backtrack;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2024/11/30 23:18
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 *  。返回 s 所有可能的分割方案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 2：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 */
public class L131 {

    List<List<String>> resList = new ArrayList<>();
    List<String> tempList = new ArrayList<>();

    public List<List<String>> partition(String s) {
        splitL(s);
        return resList;
    }

    private void splitL(String s){

        if(s == null||s.length()==0){
            resList.add(new ArrayList<>(tempList));
            return;
        }

        for(int i=1;i<=s.length();i++){
            String sStart = s.substring(0,i);
            if(isCircle(sStart)){
                tempList.add(sStart);
                splitL(s.substring(i,s.length()));
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private boolean isCircle(String s){
        int start = 0;
        int end = s.length()-1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L131().partition("aab"));;
    }
}
