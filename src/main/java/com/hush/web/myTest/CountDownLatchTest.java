package com.hush.web.myTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huangshuai
 * @Date: 2020-11-25
 * @Version 1.0
 */
public class CountDownLatchTest {


    public static Integer count = 0;
    public static CountDownLatch countDownLatch = new CountDownLatch(5);

    Lock lock = new ReentrantLock();


    public void AddNumber(int num) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " get the lock , count=" + count);
            count = count + num;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " release the lock , count=" + count);
        }
    }

    /**
     * countDownLatch  可以等计数为0后再执行后面的逻辑
     * @param args
     */
    public static void main(String[] args) {



        new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(1);
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(2);
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(3);
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(4);
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
            countDownLatchTest.AddNumber(5);
            countDownLatch.countDown();
        }).start();

        try{
            countDownLatch.await();
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
