package com.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @date 2024/12/1 00:54
 */
public class O7 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            solution(line, l, r);
        }
    }
    private static void solution(String line, int l, int r){
        String[] sArr = line.split(" ");
        List<String> list = new ArrayList<>();
        for(int i=0;i<l;i++){
            list.add(sArr[i]);
        }
        int end = r>=sArr.length-1?sArr.length-1:r;
        for(int i=l;i<=end;i++){
            list.add(sArr[end-i]);
        }
        for(int i=r+1;i<sArr.length;i++) {
            list.add(sArr[i]);
        }
        String join = String.join(" ", list);
        System.out.println(join);
    }
}
