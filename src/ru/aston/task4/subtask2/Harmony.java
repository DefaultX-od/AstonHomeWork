package ru.aston.task4.subtask2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Harmony {
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_TWO = 2;

    private final Lock lock = new ReentrantLock();
    private int turn = NUMBER_ONE;

    public void operation(int currentNumber, int nextNumber) {
        while (true) {
            lock.lock();

            try {
                if (turn == currentNumber) {
                    System.out.println(currentNumber);
                    turn = nextNumber;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Harmony harmony = new Harmony();
        final String nameThread1 = "T1";
        final String nameThread2 = "T2";

        final Thread t1 = new Thread(() -> harmony.operation(NUMBER_ONE, NUMBER_TWO), nameThread1);
        final Thread t2 = new Thread(() -> harmony.operation(NUMBER_TWO, NUMBER_ONE), nameThread2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
