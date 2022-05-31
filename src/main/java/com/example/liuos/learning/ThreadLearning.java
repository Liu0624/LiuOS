package com.example.liuos.learning;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadLearning {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @SneakyThrows
            @Override
            public void run() {
                try{
                    log.info("{} --> {}", this.getName(), "start");
                    TimeUnit.SECONDS.sleep(20);
                    log.info("{} --> {}", this.getName(), "end");
                }finally {
                    System.out.println("执行finally方法");
                }
            }
        };
        t1.setName("t1");
        //t1.start();

        Runnable ab = new Runnable(){
            @Override
            public void run() {
                log.info("{} --> {}", Thread.currentThread().getName(), "yes");
            }
        };

        Thread t2 = new Thread(ab,"t2");
        t2.start();
        //t2.interrupt();

        //true:守护线程
        //false:用户线程
        t1.setDaemon(true);
        t1.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println("main线程执行完毕");
    }
}
