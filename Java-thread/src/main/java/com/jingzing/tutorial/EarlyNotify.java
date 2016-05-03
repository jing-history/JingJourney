package com.jingzing.tutorial;

/**
 * 分析：首先启动threadA1，threadA1在removeItem（）中调用wait（），从而释放list上的对象锁。
 * 再过500ms，启动threadA2，threadA2调用removeItem（），获取list上的对象锁，也发现列表为空，
 * 从而在wait（）方法处阻塞，释放list上的对象锁。再过500ms后，启动threadB，并调用addItem，
 * 获得list上的对象锁，并在list中添加一个元素，同时用notifyAll通知所有线程。
 * threadA1和threadA2都从wait（）返回，等待获取list对象上的对象锁，并试图从列表中删除添加的元素，
 * 这就会产生麻烦，只有其中一个操作能成功。假设threadA1获取了list上的对象锁，并删除元素成功，在退出synchronized代码块时，
 * 它便会释放list上的对象锁，此时threadA2便会获取list上的对象锁，会继续删除list中的元素，但是list已经为空了，
 * 这便会抛出IndexOutOfBoundsException。
 *
 * -->要避免以上问题只需将wait外围的if语句改为while循环即可，这样当list为空时，线程便会继续等待，而不会继续去执行删除list中元素的代码。
 * 总结：在使用线程的等待/通知机制时，一般都要在while循环中调用wait（）方法，满足条件时，才让while循环退出，
 * 这样一般也要配合使用一个boolean变量（或其他能判断真假的条件，如本文中的list.isEmpty()），满足while循环的条件时，
 * 进入while循环，执行wait（）方法，不满足while循环的条件时，跳出循环，执行后面的代码。
 * Created by Louis Wang on 2016/5/3.
 */

import java.util.*;

public class EarlyNotify extends Object {
    private List list;

    public EarlyNotify() {
        list = Collections.synchronizedList(new LinkedList());
    }

    public String removeItem() throws InterruptedException {
        print("in removeItem() - entering");

        synchronized ( list ) {
            if ( list.isEmpty() ) {  //这里用if语句会发生危险
                print("in removeItem() - about to wait()");
                list.wait();
                print("in removeItem() - done with wait()");
            }

            //删除元素
            String item = (String) list.remove(0);

            print("in removeItem() - leaving");
            return item;
        }
    }

    public void addItem(String item) {
        print("in addItem() - entering");
        synchronized ( list ) {
            //添加元素
            list.add(item);
            print("in addItem() - just added: '" + item + "'");

            //添加后，通知所有线程
            list.notifyAll();
            print("in addItem() - just notified");
        }
        print("in addItem() - leaving");
    }

    private static void print(String msg) {
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }

    public static void main(String[] args) {
        final EarlyNotify en = new EarlyNotify();

        Runnable runA = new Runnable() {
            public void run() {
                try {
                    String item = en.removeItem();
                    print("in run() - returned: '" +
                            item + "'");
                } catch ( InterruptedException ix ) {
                    print("interrupted!");
                } catch ( Exception x ) {
                    print("threw an Exception!!!\n" + x);
                }
            }
        };

        Runnable runB = new Runnable() {
            public void run() {
                en.addItem("Hello!");
            }
        };

        try {
            //启动第一个删除元素的线程
            Thread threadA1 = new Thread(runA, "threadA1");
            threadA1.start();

            Thread.sleep(500);

            //启动第二个删除元素的线程
            Thread threadA2 = new Thread(runA, "threadA2");
            threadA2.start();

            Thread.sleep(500);
            //启动增加元素的线程
            Thread threadB = new Thread(runB, "threadB");
            threadB.start();

            Thread.sleep(10000); // wait 10 seconds

            threadA1.interrupt();
            threadA2.interrupt();
        } catch ( InterruptedException x ) {}
    }
}

