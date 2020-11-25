package com.hush.web.myTest;

/**
 * @Author: huangshuai
 * @Date: 2020-11-25
 * @Version 1.0
 */
public class JoinTest {


    /**
     * join 等待这个线程结束，可以用来控制线程执行顺序
     * @param args
     */
    public static void main(String[] args) {


        Thread thread1 = new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(1);
            System.out.println("count =" + CountDownLatchTest.count);
        });


        Thread thread2 = new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(2);
            System.out.println("count =" + CountDownLatchTest.count);
        });


        Thread thread3 = new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(2);
            System.out.println("count =" + CountDownLatchTest.count);
        });

        try{
            thread1.start();

            thread1.join();

            thread2.start();

            thread2.join();

            thread3.start();

            thread3.join();

        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
