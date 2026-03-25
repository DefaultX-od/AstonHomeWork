package ru.aston.task3.builder;

public class ContactValidator {
    public final static Long MIN_LONG_CELLPHONE_VALUE = 70000000000L;
    public final static Long MAX_LONG_CELLPHONE_VALUE = 89999999999L;
    public final static Integer MIN_INT_LANDLINE_VALUE = 2000000;
    public final static Integer MAX_INT_LANDLINE_VALUE = 2999999;
    public final static String EMAIL_REGEX = "@";

    public void validateEmail(final String email) throws IllegalArgumentException {
        if (email != null && !email.contains(EMAIL_REGEX)) {
            throw new IllegalArgumentException(String.format("Некорректный формат email -> \"%s\"", email));
        }
    }

    public void validateCellPhone(final Long cellPhone) throws IllegalArgumentException {
        if (cellPhone == null) {
            return;
        }

        if (cellPhone < MIN_LONG_CELLPHONE_VALUE || cellPhone > MAX_LONG_CELLPHONE_VALUE) {
            throw new IllegalArgumentException(String.format("Неверный формат номера мобильного телефона -> \"%d\"", cellPhone));
        }
    }

    public void validateLandLine(final Integer landLine) throws IllegalArgumentException {
        if (landLine == null) {
            return;
        }

        if (landLine < MIN_INT_LANDLINE_VALUE || landLine > MAX_INT_LANDLINE_VALUE) {
            throw new IllegalArgumentException(String.format("Неверный формат стационарного номера телевона -> \"%d\"", landLine));
        }
    }
}
