package com.example.liuos.learning.Lock;

import java.util.concurrent.TimeUnit;

public class LockAndAQS {
    static CreateLock lock = new CreateLock();

    public static void main(String[] args) {
        Thread A = new Thread(()->{
            testLock();
        },"Liu_ThreadA");

        Thread B = new Thread(()->{
            testLock();
        },"Lee_ThreadB");

        A.start();
        B.start();
    }

    public static void testLock(){
        lock.lock();

        try{
            System.out.println("获取到了锁 --> " + Thread.currentThread().getName());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
