package com.example.barungsofthomehwrk.validator;

import com.example.barungsofthomehwrk.model.Customer;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class CustomerValidator {

    public static boolean validate(Customer customer){
        return emailValidation(customer.getEmail()) && (customer.getAge() <= 0 && (customer.getFirstName() == null ||
                customer.getLastName() == null || "".equals(customer.getFirstName()) || "".equals(customer.getLastName())));
    }

    private static boolean emailValidation(String email){
        boolean isValid=false;
        try{
            InternetAddress internetAddress=new InternetAddress(email);
            internetAddress.validate();
            isValid=true;
        } catch (AddressException e) {
            System.err.println("Exception for email "+email);
        }
        return isValid;
    }
}
