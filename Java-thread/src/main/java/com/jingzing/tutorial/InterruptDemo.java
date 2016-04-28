package com.jingzing.tutorial;

/**
 * 当一个线程运行时，另一个线程可以调用对应的Thread对象的interrupt（）方法来中断它，该方法只是在目标线程中设置一个标志，
 * 表示它已经被中断，并立即返回。这里需要注意的是，如果只是单纯的调用interrupt（）方法，线程并没有实际被中断，会继续往下执行
 * Created by Louis Wang on 2016/4/28.
 */

public class InterruptDemo extends Object implements Runnable{
    public void run() {

        try {
            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("in run() - woke up");
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("in run() - interrupted while sleeping");
            //处理完中断异常后，返回到run（）方法人口，
            //如果没有return，线程不会实际被中断，它会继续打印下面的信息
            return;
        }
        System.out.println("in run() - leaving normally");
    }

    public static void main(String[] args) {
        InterruptDemo si = new InterruptDemo();
        Thread t = new Thread(si);
        t.start();
        //主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        //中断线程t
        t.interrupt();
        System.out.println("in main() - leaving");
    }
}
