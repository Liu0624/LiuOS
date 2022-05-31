package com.example.liuos.learning;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Shunxu {
    private static final Object obj = new Object();
    private static boolean isRun = false;

    Thread th1;
    Thread th2;

    public static void main(String[] args) throws InterruptedException {

        synchronized (obj){
            obj.wait();
        }
        //1.使用wait和notify
//        Thread t1 = new Thread(()->{
//            while(true){
//                synchronized (obj){
//                    while(isRun){
//                        try {
//                            obj.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    log.info("{}---运行---", Thread.currentThread().getName());
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    isRun = true;
//                    obj.notify();
//                }
//            }
//        },"t1");
//        Thread t2 = new Thread(()->{
//            while(true){
//                synchronized (obj){
//                    while(!isRun){
//                        try {
//                            obj.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    log.info("{}---运行---", Thread.currentThread().getName());
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    isRun = false;
//                    obj.notify();
//                }
//            }
//        },"t2");


        //2.使用park和unpark
//        Thread t1 = new Thread(()->{
//            while(true){
//                synchronized (obj){
//                    while(isRun){
//                        LockSupport.park();
//                    }
//
//                    log.info("{}---运行---", Thread.currentThread().getName());
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    isRun = true;
//                    //LockSupport.unpark(t2);
//                }
//            }
//        },"t1");
//
//        Thread t2 = new Thread(()->{
//            while(true){
//                synchronized (obj){
//                    while(!isRun){
//                        LockSupport.park();
//                    }
//
//                    log.info("{}---运行---", Thread.currentThread().getName());
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    isRun = false;
//                    LockSupport.unpark(t1);
//                }
//            }
//        },"t2");

        //3.lock
        /*ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();

        Thread t1 = new Thread(()->{
            while(true){
                lock.lock();
                try{
                    condition1.await();
                    log.info("{}--a","t1");
                    TimeUnit.SECONDS.sleep(2);
                    condition2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t1");

        Thread t2 = new Thread(()->{
            while(true){
                lock.lock();
                try{
                    condition2.await();
                    log.info("{}--b","t2");
                    TimeUnit.SECONDS.sleep(2);
                    condition3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t2");

        Thread t3 = new Thread(()->{
            while(true){
                lock.lock();
                try{
                    condition3.await();
                    log.info("{}--c","t3");
                    TimeUnit.SECONDS.sleep(2);
                    condition1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(10);
        lock.lock();
        try{
            condition1.signal();
        }finally {
            lock.unlock();
        }*/

        ConditionTest alock = new ConditionTest();
        Condition c1 = alock.newCondition();
        Condition c2 = alock.newCondition();
        Condition c3 = alock.newCondition();

        new Thread(()->{
            alock.print(c1, c2);
        }).start();

        new Thread(()->{
            alock.print(c2, c3);
        }).start();

        new Thread(()->{
            alock.print(c3, c1);
        }).start();

        alock.lock();
        try{
            c1.signal();
        }finally {
            alock.unlock();
        }

    }

}

@Slf4j
class ConditionTest extends ReentrantLock{
    public void print(Condition condition, Condition nextCondition){
        while(true){
            lock();

            try{
                condition.await();
                log.info("{}-->运行", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(2);
                nextCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }

    }
}

@Slf4j
class ParkTest{
    public void print(Thread nextThread) throws InterruptedException {
        while(true){
            LockSupport.park();
            log.info("{}-->", Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(2);
            LockSupport.unpark(nextThread);
        }
    }
}
