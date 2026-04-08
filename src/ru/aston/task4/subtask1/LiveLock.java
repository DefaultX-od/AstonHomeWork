package ru.aston.task4.subtask1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public void operation(Lock firstLock, Lock secondLock, String lockName) {
        String name = Thread.currentThread().getName();

        while (true) {
            if (!firstLock.tryLock()) {
                continue;
            }

            try {
                System.out.printf("%s захватил %s и ждет другой...%n", name, lockName);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            if (secondLock.tryLock()) {
                System.out.printf("%s захватил оба замка!%n", name);
            } else {
                System.out.printf("%s не смог взять другой, отпускает %s...%n", name, lockName);
                firstLock.unlock();
                continue;
            }

            System.out.println("выполняется операция");
            break;
        }

        secondLock.unlock();
        firstLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        final LiveLock liveLock = new LiveLock();
        final String nameThread1 = "T1";
        final String nameThread2 = "T2";
        final String nameLock1 = "lock1";
        final String nameLock2 = "lock2";

        Thread t1 = new Thread(() -> liveLock.operation(liveLock.lock1, liveLock.lock2, nameLock1), nameThread1);
        Thread t2 = new Thread(() -> liveLock.operation(liveLock.lock2, liveLock.lock1, nameLock2), nameThread2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
