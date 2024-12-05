package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date 2024/12/4 21:20
 */
public class L93_2 {

    private List<List<String>> resultList = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        split(s,0,new ArrayList<>());
        List<String> collect = resultList.stream().map(l -> String.join(".", l)).collect(Collectors.toList());

        return collect ;
    }

    private void split(String s,int start,List<String> list){
        if(list.size()==4 && start == s.length()){
            resultList.add(list);
            return;
        }
        if(list.size()==4 && start < s.length()){
            return;
        }
//        if(list.size()<4 && start >= s.length()){
//            return;
//        }

        for(int i=start+1;i<=start+3 && i<=s.length();i++){
            String temp = s.substring(start,i);
            if(!validIp(temp)){
                break;
            }
            List<String> tempList = new ArrayList<>(list);
            tempList.add(temp);
            split(s,i,tempList);
        }


    }

    private boolean validIp(String s){
        if(s.length()>0){
            Integer ip = Integer.valueOf(s);

            if(ip>0 && s.startsWith("0")){
                return false;
            }
            if(ip==0 && s.length()>1){
                return false;
            }
            if(ip>255){
                return false;
            }
            return true;

        }else{
            return false;
        }

    }


    public static void main(String[] args) {
        List<String> strings = new L93_2().restoreIpAddresses("25525511135");
        System.out.println(strings);

        System.out.println(new L93_2().validIp("255"));;
    }
}
