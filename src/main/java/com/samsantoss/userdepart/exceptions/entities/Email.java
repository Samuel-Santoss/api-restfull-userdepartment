package com.samsantoss.userdepart.exceptions.entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;
import java.util.regex.Pattern;


@Embeddable // Permite ser embutido em entidades do JPA
public class Email {
        private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

        private String email_value;

        public Email() {} // Construtor protegido para JPA

        public Email(String value) {
        setValue(value); // Reutiliza a validação do setter
        }

         public String getValue() {
        return email_value;
        }

        public void setValue(String value) {
            if (value == null || !PATTERN.matcher(value).matches()) {
                throw new IllegalArgumentException("E-mail inválido: " + value);
            }
            this.email_value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Email email = (Email) o;
            return Objects.equals(email_value, email.email_value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email_value);
        }

        @Override
        public String toString() {
            return email_value;
        }

}
