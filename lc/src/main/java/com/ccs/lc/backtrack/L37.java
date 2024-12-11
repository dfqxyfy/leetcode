package com.ccs.lc.backtrack;

import java.util.*;

public class L37 {

    boolean over = false;
    public void solveSudoku(char[][] board) {

        backtracking(board,0,0);
    }

    public void backtracking(char[][] board,int x,int y){
        if(x>8 || y>8){
            over = true;
            return;
        }

        int nextX = x+1;
        int nextY = y;

        if(x==8){
            nextX = 0;
            nextY = y+1;
        }

        if(board[x][y] != '.'){
            backtracking(board,nextX,nextY);
        }else{
            List<Character> characters = validList(board, x, y);
            if(characters.size()==0){
                return;
            }
            for(int i=0;i<characters.size();i++){
                board[x][y] = characters.get(i);

                backtracking(board,nextX,nextY);
                if(over){
                    return;
                }
                board[x][y] = '.';
            }

        }

    }


    private List<Character> validList(char[][] board,int x, int y){
        Set<Character> characters = validSet(board, x, y);
        return new ArrayList<>(characters);
    }
    private Set<Character> validSet(char[][] board,int x, int y){
        Set<Character> sets = new HashSet<>();
        for(int i=0;i<board.length;i++){
            if (board[i][y] != '.') {
                sets.add(board[i][y]);
            }
        }
        for(int j=0;j<board[0].length;j++) {
            if (board[x][j] != '.') {
                sets.add(board[x][j]);
            }
        }
        int startX = x/3*3;
        int startY = y/3*3;
        for(int i=startX;i<startX+3;i++){
            for(int j=startY;j<startY+3;j++){
                if (board[i][j] != '.') {
                    sets.add(board[i][j]);
                }
            }
        }

        Set<Character> newSets = new HashSet<>();
        for(char i='1';i<='9';i++){
            if(!sets.contains(i)){
                newSets.add(i);
            }
        }

        return newSets;
    }


    public static void main(String[] args) {
        char[][] borads = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}
                ;

        borads=new char[][]{{'.','.','.','.','.','.','.','.','.'},{'.','9','.','.','1','.','.','3','.'},{'.','.','6','.','2','.','7','.','.'},{'.','.','.','3','.','4','.','.','.'},{'2','1','.','.','.','.','.','9','8'},{'.','.','.','.','.','.','.','.','.'},{'.','.','2','5','.','6','4','.','.'},{'.','8','.','.','.','.','.','1','.'},{'.','.','.','.','.','.','.','.','.'}};

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(borads[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        L37 l37 = new L37();
        l37.solveSudoku(borads);


        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(borads[i][j]+" ");
            }
            System.out.println();
        }
    }
}
