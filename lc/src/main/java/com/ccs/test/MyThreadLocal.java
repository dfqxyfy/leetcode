package com.ccs.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @date 2024/11/21 7:54 AM
 */
public class MyThreadLocal {
    static ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(100,100,100, TimeUnit.SECONDS,new ArrayBlockingQueue<>(885));

        System.out.println(Thread.currentThread().getId()+" main Thread");
        for(int i=0;i<100;i++) {
            executorService.execute(
                new Thread(){
                @Override
                protected void finalize() throws Throwable {
                    super.finalize();
                    System.out.println(getName()+" "+getId()+" MyObject finalize method is called");
                }
                @Override
                public void run(){
                    byte[] b = new byte[50 * 1024 * 10240];
                    //threadLocal.set(b);
                    System.out.println(getName()+" "+getId()+" over...");

                }
            }//.start();


            );



            //});
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
