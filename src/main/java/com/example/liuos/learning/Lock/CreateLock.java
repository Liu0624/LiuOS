package com.example.liuos.learning.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 1.implements Lock
 * 2.静态内部类 继承AQS
 */
public class CreateLock implements Lock {

    private static class Sync extends AbstractQueuedSynchronizer{
        //3.重写AQS的方法，达到预期
        //排他锁需要以下两个方法
        @Override
        protected boolean tryAcquire(int arg) {//加锁
            //定制化 以“Liu"开头的线程
            if(!Thread.currentThread().getName().startsWith("Liu")){
                return false;
            }
            if(compareAndSetState(0, arg)){
                setExclusiveOwnerThread(Thread.currentThread());//设置当前线程为主要执行者
                return true; //加锁成功
            }
            return false;//加锁失败
        }

        @Override
        protected boolean tryRelease(int arg) {//解锁
            if(getState() == 0) {//本来就没有锁，你还要解锁
                throw new IllegalMonitorStateException();
            }
            setState(0);
            setExclusiveOwnerThread(null);
            return true;
        }

        Condition getContion(){
            return new ConditionObject();
        }
    }

    //创建内部类
    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);//AQS的模板方法
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.getContion();
    }
}
