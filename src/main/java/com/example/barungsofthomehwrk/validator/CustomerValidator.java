package com.example.barungsofthomehwrk.validator;

import com.example.barungsofthomehwrk.exception.WrongAge;
import com.example.barungsofthomehwrk.exception.WrongEmail;
import com.example.barungsofthomehwrk.exception.WrongFirstName;
import com.example.barungsofthomehwrk.exception.WrongLastName;
import com.example.barungsofthomehwrk.model.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidator {

    public static void validate(Customer customer) throws WrongEmail, WrongAge, WrongFirstName, WrongLastName {
        if (customer.getEmail()==null || emailValidation(customer.getEmail()))
            throw new WrongEmail();
        if (customer.getAge()==null || customer.getAge()<=0)
            throw new WrongAge();
        if (customer.getFirstName() == null || "".equals(customer.getFirstName()))
            throw new WrongFirstName();
        if (customer.getLastName() == null || "".equals(customer.getLastName()))
            throw new WrongLastName();
    }

    private static final String EMAIL_PATTERN =
            "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";

    private static boolean emailValidation(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

}
