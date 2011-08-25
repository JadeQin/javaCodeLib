package test.thinkingInJava.ch20;

import java.util.Random;

public class ThreadTest {

    public static void main(String[] arhs) {
        // Thread t1 = new MyThread("t1");
        // t1.start();
        // new MyThread("t1").start();
        // new MyThread("t2").start();
        // new MyThread("t3").start();

        // new MyThread1().start();
        for (int a = 1; a < 10; a++) {
            for (int c = 1; c < 10; c++) {
                for (int b = 0; b < 10; b++) {
                    for (int d = 0; d < 10; d++) {
                        boolean m = (a * 10 + b) * (c * 10 + d)==b*1000+c*100+a*10+d;
                        boolean n = (a * 10 + d) * (c * 10 + b)==a * 1000 + b * 100 + c * 10 + d;
                        if (m&& n ) {
                            System.out.println("春："+a+",夏："+b+",秋："+c+",冬："+d);
                        }
                    }
                }
            }
        }
    }
}

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public void run() {
        int i = new Random().nextInt(10);
        System.out.println(getName() + "---" + i + "---" + activeCount());
        if (i % 2 == 0) {
            new MyThread(getName() + "**" + i).start();
        }
        System.out.println(toString() + "##");
        Thread.yield();

    }
}

class MyThread1 extends Thread {

    public void run() {
        new MyThread2().start();
    }
}

class MyThread2 extends Thread {

    public void run() {
        System.out.println(this);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i % 2 == 0) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                }
            }
        }
    }
}

/**
 * t1---2---4 t3---3---4 t2---2---4 t2**2---0---4 t1**2---8---4 t2**2**0---8---5
 * t1**2**8---2---5 t2**2**0**8---6---5 t1**2**8**2---5---5
 * t2**2**0**8**6---8---4 t2**2**0**8**6**8---2---4 t2**2**0**8**6**8**2---6---4
 * t2**2**0**8**6**8**2**6---3---4
 */
