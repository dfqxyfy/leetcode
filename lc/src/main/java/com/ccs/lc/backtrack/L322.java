package com.ccs.lc.backtrack;

import java.util.*;

/**
 * 332. 重新安排行程
 * 困难
 * 相关标签
 * 相关企业
 * 给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
 *
 * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
 *
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
 * 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
 *
 * 使用基本算法
 */
public class L322 {

    private List<List<String>> resList = new ArrayList<>();

    private LinkedList<String> temp = new LinkedList<>();
    private boolean[] used ;

    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        backtracking(tickets);

        resList.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int i=0;
                while(i<o1.size()-1 && i<o2.size()-1 && o1.get(i).equals(o2.get(i))){
                    i++;
                }
                return o1.get(i).compareTo(o2.get(i));
            }
        });

        return resList.get(0);

    }

    public void backtracking(List<List<String>> tickets){

        if(temp.size()==tickets.size()+1){
            resList.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<tickets.size();i++){
            if(temp.size()==0){
                if("JFK".equals(tickets.get(i).get(0))){
                    temp.add("JFK");
                    temp.add(tickets.get(i).get(1));
                    used[i] = true;
                }else{
                    continue;
                }
            }else{
                if(temp.getLast().equals(tickets.get(i).get(0)) && used[i]==false){
                    temp.add(tickets.get(i).get(1));
                    used[i] = true;
                }else{
                    continue;
                }
            }

            backtracking(tickets);
            temp.removeLast();
            if(temp.size()==1){
                temp.removeLast();
            }
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        System.out.println("123".compareTo("235"));
        System.out.println("3".compareTo("235"));

        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK","SFO"));
        tickets.add(Arrays.asList("JFK","ATL"));
        tickets.add(Arrays.asList("SFO","ATL"));
        tickets.add(Arrays.asList("ATL","JFK"));
        tickets.add(Arrays.asList("ATL","SFO"));
        L322 l322 = new L322();
        l322.findItinerary(tickets);
        System.out.println(l322.resList);

        //Arrays.asList("")
    }
}
