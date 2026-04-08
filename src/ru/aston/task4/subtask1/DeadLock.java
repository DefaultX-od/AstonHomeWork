package ru.aston.task4.subtask1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public final Lock lock1 = new ReentrantLock(true);
    public final Lock lock2 = new ReentrantLock(true);

    public void operation(Lock firstLock, Lock secondLock, String lockName) {
        String threadName = Thread.currentThread().getName();

        firstLock.lock();
        System.out.printf("%s захватил %s и ждет другой...%n", threadName, lockName);

        secondLock.lock();
        System.out.printf("%s захватил оба замка!%n", threadName);

        System.out.println("выполняется операция.");

        secondLock.unlock();
        firstLock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        final DeadLock deadLock = new DeadLock();
        final String nameThread1 = "T1";
        final String nameThread2 = "T2";
        final String nameLock1 = "lock1";
        final String nameLock2 = "lock2";

        Thread t1 = new Thread(() -> deadLock.operation(deadLock.lock1, deadLock.lock2, nameLock1), nameThread1);
        Thread t2 = new Thread(() -> deadLock.operation(deadLock.lock2, deadLock.lock1, nameLock2), nameThread2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
