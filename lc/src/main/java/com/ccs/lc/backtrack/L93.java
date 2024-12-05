package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2024/12/4 15:29
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class L93 {

    List<List<String>> resList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //List<String> resList = new ArrayList<>();
        split(s,new ArrayList<>());
        System.out.println(resList);
        List<String> collect = resList.stream().map(t -> String.join(".", t)).collect(Collectors.toList());
        return collect;
    }

    public void split(String s,List<String> list){
        if(list.size()==4 && (s==null || "".equals(s) )){
            resList.add(new ArrayList<>(list));
            return;
        }else if(list.size()==4&& s.length()>0){
            return;
        }else if(s.length()==0 && list.size()<4){
            return;
        }

        for(int i=1;i<=3&&i<=s.length();i++){
            String temp = s.substring(0,i);

            Integer seg = Integer.valueOf(temp);
            if(seg>=256){
                break;
            }
            if(temp.length()>1 && temp.startsWith("0")){
                break;
            }
            list.add(temp);
            List<String> templist = new ArrayList<>(list);
            String nextStr = s.substring(i,s.length());
            split(nextStr, templist);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new L93().restoreIpAddresses("25525511135");
        System.out.println(strings);
    }
}
