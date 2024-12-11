package com.ccs.lc.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class L455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gEnd = g.length-1;
        int sEnd = s.length-1;

        int count = 0;
        while( gEnd>=0 && sEnd >=0){
            if(s[sEnd] >= g[gEnd]){
                sEnd--;
                gEnd--;
                count++;
            }else if(g[gEnd]>s[sEnd]){
                gEnd--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g=new int[]{1,2,3};
        int[] s=new int[]{1,1};
        System.out.println(new L455().findContentChildren(g,s));;
    }
}
