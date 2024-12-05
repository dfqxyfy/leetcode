package com.ccs.lc.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2024/11/20 11:11 AM
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的
 * 字母异位词
 * 。
 */
public class L242 {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            Integer integer = map.get(t.charAt(i));
            if(integer == null){
                return false;
            }
            if(integer-1 ==0){
                map.remove(t.charAt(i));
            }else{
                map.put(t.charAt(i),integer-1);
            }
        }
        return map.size()==0;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        s="rat";
        t="car";
        System.out.println(new L242().isAnagram(s,t));;
    }
}
