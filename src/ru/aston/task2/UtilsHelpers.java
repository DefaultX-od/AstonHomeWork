package ru.aston.task2;

public class UtilsHelpers {
    private UtilsHelpers() {

    }
    public static int strSafeParseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
