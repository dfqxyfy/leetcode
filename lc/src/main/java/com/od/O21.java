package com.od;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @date 2024/12/4 10:36
 *
 * 磁盘的容量单位常用的有M、G、T
 * 他们之间的换算关系为1T =1024G，1G=1024M
 * 现在给定n块磁盘的容量，请对他们按从小到大的顺序进行稳定排序
 * 例如给定5块盘的容量
 * 5
 * 1T
 * 20M
 * 3G
 * 10G6T
 * 3M12G9M
 * 排序后的结果为
 * 20M
 * 3G
 * 3M12G9M
 * 1T
 * 10G6T
 * 注意单位可以重复出现
 * 上述3M12G9M表示的容量即为3M12G9M和12M12G相等
 */
public class O21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] arr = new String[num];
        for(int i=0;i<num;i++){
            arr[i] = scanner.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return convert(o1)-convert(o2);
            }
        });

        System.out.println(Arrays.toString(arr));


    }
    public static int convert(String s){
        int res = 0;
        StringBuilder strb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'M'){
                res +=Integer.valueOf(new String(strb));
                strb = new StringBuilder();
            }else if(s.charAt(i)=='G'){
                res +=1024L*Integer.valueOf(new String(strb));
                strb = new StringBuilder();
            }else if(s.charAt(i) == 'T'){
                res +=1024*1024L*Integer.valueOf(new String(strb));
                strb = new StringBuilder();
            }else{
                strb.append(s.charAt(i));
            }
        }
        return res;
    }
}
