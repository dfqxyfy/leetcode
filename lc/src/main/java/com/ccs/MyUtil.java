package com.ccs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @date 2024/11/16 4:20 PM
 */
public class MyUtil {
    public static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void sleep(){
        sleep(1000);
    }


    public static void log(String... args){
        String join = String.join(" ", args);
        System.out.println(join);
    }

    public static void log(Object... args){
        sleep();
        List<String> collect = Arrays.stream(args).map(s -> String.valueOf(s)).collect(Collectors.toList());
        String join = String.join(" ", collect);
        System.out.println(join);
    }

    public static void info(Object obj){
        if(obj instanceof Collection){
            ((Collection)obj).forEach(s-> System.out.print(String.valueOf(s+" ")));
            System.out.println();
        }else if(obj instanceof Object[]){
            Object[] obj1 = (Object[]) obj;
            for(Object o:obj1){
                System.out.print(String.valueOf(o)+" ");
            }
            System.out.println();
        }else if(obj.getClass().isArray()){
            int length = java.lang.reflect.Array.getLength(obj);

            // 使用for-each循环遍历数组
            for (int i = 0; i < length; i++) {
                Object item = java.lang.reflect.Array.get(obj, i);
                System.out.print(item+" ");
            }
            System.out.println();
        }
    }
}
