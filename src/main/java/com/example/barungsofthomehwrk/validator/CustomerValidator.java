package com.example.barungsofthomehwrk.validator;

import com.example.barungsofthomehwrk.model.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidator {

    public static boolean validate(Customer customer){
        System.err.println(emailValidation(customer.getEmail()));
        return customer.getEmail()!=null && emailValidation(customer.getEmail()) && customer.getAge() > 0 &&
                (customer.getFirstName() != null || customer.getLastName() != null || !"".equals(customer.getFirstName()) ||
                !"".equals(customer.getLastName()));
    }

    private static final String EMAIL_PATTERN =
            "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";

    private static boolean emailValidation(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

}
