package ru.aston.task4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);
    private volatile int turn = 1;

    public void operation1() {
        while (true) {
            try {
                if (!lock1.tryLock(10, TimeUnit.MILLISECONDS)) {
                    continue;
                }

                Thread.sleep(10);

                if (!lock2.tryLock()) {
                    lock1.unlock();
                    continue;
                }

                if (turn == 1) {
                    System.out.println(1);
                    turn = 2;
                }

                lock2.unlock();
                lock1.unlock();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void operation2() {
        while (true) {
            try {
                if (!lock2.tryLock(10, TimeUnit.MILLISECONDS)) {
                    continue;
                }

                Thread.sleep(10);

                if (!lock1.tryLock()) {
                    lock2.unlock();
                    continue;
                }

                if (turn == 2) {
                    System.out.println(2);
                    turn = 1;
                }

                lock1.unlock();
                lock2.unlock();

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        LiveLock liveLock = new LiveLock();
        new Thread(liveLock::operation1, "T1").start();
        new Thread(liveLock::operation2, "T2").start();
    }
}
