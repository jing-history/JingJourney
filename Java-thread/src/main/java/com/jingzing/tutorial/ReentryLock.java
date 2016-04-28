package com.jingzing.tutorial;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁，也叫做递归锁，指的是同一线程 外层函数获得锁之后 ，内层递归函数仍然有获取该锁的代码，但不受影响。
 * 在JAVA环境下 ReentrantLock 和synchronized 都是 可重入锁
 * Created by Louis Wang on 2016/4/28.
 */

public class ReentryLock implements Runnable {
    /*public synchronized void get(){
        System.out.println("get:" + Thread.currentThread().getId());
        set();
    }

    private synchronized void set() {
        System.out.println("set:" + Thread.currentThread().getId());
    }

    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentryLock lock = new ReentryLock();
        new Thread(lock).start();
        new Thread(lock).start();
        new Thread(lock).start();

    }*/


    /**********************ReentrantLock *************************************/
    ReentrantLock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        set();
        lock.unlock();
    }

    public void set(){
        lock.lock();
        System.out.println(Thread.currentThread().getId());
        lock.unlock();
    }

    public void run() {
        get();
    }

    public static void main(String[] args) {
        ReentryLock lock = new ReentryLock();
        new Thread(lock).start();
        new Thread(lock).start();
        new Thread(lock).start();

    }
}
