package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2024/11/28 23:47
 */
public class L17 {

    Map<Character, String> phoneMap = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    private String digits = null;
    private List<Character> tempList = new ArrayList<>();
    private List<String> resultList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        backtrack(0);

        return resultList;
    }

    public void backtrack(int cur) {
        if (cur > digits.length()) {
            return;
        }
        if (cur == digits.length()) {
            StringBuilder strb = new StringBuilder();
            for (int i = 0; i < tempList.size(); i++) {
                strb.append(String.valueOf(tempList.get(i)));
            }
            resultList.add(strb.toString());
            return;
        }
        char c = digits.charAt(cur);
        String s = phoneMap.get(c);
        for (int j = 0; j < s.length(); j++) {
            tempList.add(s.charAt(j));
            backtrack(cur + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new L17().letterCombinations("23");
        System.out.println(strings);
    }
}
