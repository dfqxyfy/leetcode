package com.ccs.lc;

import com.ccs.MyUtil;

/**
 * @date 2024/11/18 11:59 AM
 * 844. 比较含退格的字符串
 * 简单
 * 相关标签
 * 相关企业
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 */
public class L844_3 {

    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;
        int sskip=0;
        int tskip=0;
        while(i>=0&&j>=0) {
            MyUtil.log(i,j);
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    sskip++;
                    i--;
                } else if (sskip > 0) {
                    i--;
                    sskip--;
                }else{
                    break;
                }


            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    j--;
                    tskip++;
                }else if (tskip > 0) {
                    j--;
                    tskip--;
                }else{
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                } else {

                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(new L844_3().backspaceCompare(s,t));;
    }

}
