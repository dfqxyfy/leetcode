package com.ccs.lc;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @date 2024/11/17 12:53 AM
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 1. 使用栈方式
 */
public class L844 {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stacks = new LinkedList<>();
        Deque<Character> stackt = new LinkedList<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c != '#') {
                stacks.push(c);
            }
            if (c == '#' && !stacks.isEmpty()) {
                stacks.pop();
            }
        }

        char[] chart = t.toCharArray();
        for (char c : chart) {
            if (c != '#') {
                stackt.push(c);
            }
            if (c == '#' && !stackt.isEmpty()) {
                stackt.pop();
            }
        }

        while (stacks.size() == stackt.size() && !stacks.isEmpty()) {
            if (stacks.pop() != stackt.pop()) {
                return false;
            }
        }
        if (stacks.isEmpty() && stackt.isEmpty()) {
            return true;
        }

        return false;
    }

    public boolean backspaceCompare2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int slen = chars.length - 1;

        int tlen = chart.length - 1;
        int sskip = 0;
        int tskip = 0;
        while (slen >= 0 || tlen >= 0) {
            while (slen >= 0) {
                if (chars[slen] == '#') {
                    sskip++;
                    slen--;
                } else if (sskip > 0) {
                    sskip--;
                    slen--;
                } else {
                    break;
                }
            }
            while (tlen >= 0) {
                if (chart[tlen] == '#') {
                    tskip++;
                    tlen--;
                } else if (tskip > 0 ) {
                    tskip--;
                    tlen--;
                } else {
                    break;
                }
            }


            if (slen >= 0 && tlen >= 0) {
                if( chars[slen] != chart[tlen]) {
                    return false;
                }else{
                    return true;
                }

            } else  if(slen<0||tlen<0){
                if (slen >= 0 || tlen >= 0) {
                    return false;
                }
            }
            slen--;
            tlen--;
        }
        return true;

    }


    public boolean backspaceCompare3(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new L844().backspaceCompare("ab#c", "ad#c"));
        ;
        System.out.println(new L844().backspaceCompare("ab##", "c#d#"));
        ;
        System.out.println(new L844().backspaceCompare("a#c", "b"));
        ;

        System.out.println(new L844().backspaceCompare2("ab#c", "ad#c"));
        ;
        System.out.println(new L844().backspaceCompare2("ab##", "c#d#"));
        ;
        System.out.println(new L844().backspaceCompare2("a#c", "b"));
        ;

        System.out.println(new L844().backspaceCompare3("ab#c", "ad#c"));
        ;
        System.out.println(new L844().backspaceCompare3("ab##", "c#d#"));
        ;
        System.out.println(new L844().backspaceCompare3("a#c", "b"));
        ;
    }
}
