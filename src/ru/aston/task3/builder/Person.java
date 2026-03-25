package ru.aston.task3.builder;

import java.util.Date;

public class Person {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final Date birthDate;
    private final String gender;
    private final String email;
    private final Long cellPhone;
    private final Integer landLine;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.birthDate = builder.birthDate;
        this.gender = builder.gender;
        this.email = builder.email;
        this.cellPhone = builder.cellPhone;
        this.landLine = builder.landLine;
    }

    @Override
    public String toString() {
        return String.format("firstName: %s; middleName: %s; lastName: %s; birthDate: %s; gender: %s; email: %s; cellPhone: %d; landline: %d", firstName, middleName, lastName, birthDate, gender, email, cellPhone, landLine);
    }

    public static class Builder {
        private final ContactValidator contactValidator = new ContactValidator();

        private final String firstName;
        private final String lastName;
        private final Date birthDate;
        private final String gender;
        private String middleName;
        private String email;
        private Long cellPhone;
        private Integer landLine;

        public Builder(final String firstName, final String lastName, final Date birthDate, final String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.gender = gender;
        }

        public Builder middleName(final String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder cellPhone(final Long cellPhone) {
            this.cellPhone = cellPhone;
            return this;
        }

        public Builder landLine(final Integer landLine) {
            this.landLine = landLine;
            return this;
        }

        public Person build() {
            contactValidator.validateEmail(this.email);
            contactValidator.validateCellPhone(this.cellPhone);
            contactValidator.validateLandLine(this.landLine);

            return new Person(this);
        }
    }
}