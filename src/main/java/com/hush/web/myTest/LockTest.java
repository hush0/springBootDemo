package com.hush.web.myTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: huangshuai
 * @Date: 2020-11-24
 * @Version 1.0
 */
public class LockTest {


    public static Integer count = 0;

    Lock lock = new ReentrantLock();


    public void AddNumber(int num) {
        lock.lock();
        try {
            count = count + num;
            System.out.println(Thread.currentThread().getName() + " get the lock");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " release the lock");
        }
    }


    public static void main(String[] args) {


        new Thread(() -> {
            LockTest lockTest = new LockTest();
            lockTest.AddNumber(2);
        }).start();

        new Thread(() -> {
            LockTest lockTest = new LockTest();
            lockTest.AddNumber(1);
        }).start();

        new Thread(() -> {
            LockTest lockTest = new LockTest();
            lockTest.AddNumber(5);
        }).start();

        new Thread(() -> {
            LockTest lockTest = new LockTest();
            lockTest.AddNumber(9);
        }).start();


        System.out.println(count);


    }



}
