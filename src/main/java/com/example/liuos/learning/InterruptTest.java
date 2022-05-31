package com.example.liuos.learning;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class InterruptTest {
    public static void main(String[] args) {
        Thread a = new Thread(()->{
            for(int i = 0; i < 10; ++i){
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "a");

        a.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            a.interrupt();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
