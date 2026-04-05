package ru.aston.task4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public void operation1() {
        this.lock1.lock();
        System.out.println(1);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.lock2.lock();
        this.lock2.unlock();
        this.lock1.unlock();
    }

    public void operation2() {
        this.lock2.lock();
        System.out.println(2);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.lock1.lock();
        this.lock1.unlock();
        this.lock2.unlock();
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        new Thread(deadLock::operation1, "T1").start();
        new Thread(deadLock::operation2, "T2").start();
    }
}
