package com.ccs.lc.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后问题
 */
public class L51 {

    //private List<List<String>> resultList = new ArrayList<>();
    private LinkedList<Position> temp = new LinkedList<>();
    private List<List<Position>> resPosition = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //queens = new int[n][n];
        backtracking(n,0);

        List<List<String>> resultList = new ArrayList<>();

        for(int i=0;i<resPosition.size();i++){
            List<String> list = new ArrayList<>();


            List<Position> positions = resPosition.get(i);
            int yIndex = 0;
            while(yIndex<n) {
                StringBuilder strb = new StringBuilder();
                for (int j = 0; j < positions.size(); j++) {

                    if (positions.get(yIndex).y == j) {
                        strb.append("Q");
                    } else {
                        strb.append(".");
                    }

                }
                yIndex++;
                list.add(strb.toString());
            }

            resultList.add(new ArrayList<>(list));
        }

        return resultList;

    }

    public void backtracking(int n,int startx){
        if(startx>=n){
            resPosition.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<n;i++){
            Position position = new Position(startx, i);
            if(!valid(position)){
                continue;
            }
            temp.add(position);
            backtracking(n,startx+1);
            temp.removeLast();
        }
    }

    private boolean valid(Position p) {

        if(temp.size()==0){
            return true;
        }
        for(int i=0;i<temp.size();i++){
            Position tempP = temp.get(i);
            if(tempP.x==p.x || tempP.y == p.y){
                return false;
            }
            if(Math.abs(tempP.x-p.x) == Math.abs(tempP.y-p.y)){
                return false;
            }
        }
        return true;

    }



    class Position{
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }




    public static void main(String[] args) {
        List<List<String>> lists = new L51().solveNQueens(4);
        System.out.println(lists);
    }
}
