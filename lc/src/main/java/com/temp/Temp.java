package com.temp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @date 2024/11/23 11:40 AM
 */
public class Temp {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put("aa","bb");

        for(int i=1;i<100;i++){
            for(int j=1;j<100;j++){
                int c = i^j;
                if(c==i){
                    System.out.println(""+i+"  "+j+" "+c);
                }

                int tempi = c^j;


            }
        }
    }
}
