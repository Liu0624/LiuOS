package com.example.liuos.learning.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    //非公平锁
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        /**
         * 1. lock里面都是调用的AQS的模板方法
         *    AQS模板方法会调用可重写的普通方法
         *    tryAcquire tryRelease
         *    tryAcquireShared tryReleaseShared
         *    isHeldExclusively 线程持有情况
         *
         *    你 -- lock.lock -- sync.acquire(模板方法) -- Lock你复写的五大方法之一
         */
        lock.lock();


    }
}
