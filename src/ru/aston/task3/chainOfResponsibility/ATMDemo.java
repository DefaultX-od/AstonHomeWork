package ru.aston.task3.chainOfResponsibility;

import java.util.Scanner;

public class ATMDemo {
    public static int getUserInput() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(Strings.INPUT_AMOUNT_MESSAGE.getStr());
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        final ATM atm = new ATM();
        atm.withdraw(getUserInput());
    }
}
