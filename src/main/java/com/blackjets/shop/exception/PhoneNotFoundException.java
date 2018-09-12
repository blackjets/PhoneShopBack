package com.blackjets.shop.exception;

public class PhoneNotFoundException extends RuntimeException {

    private final int phoneId;

    public PhoneNotFoundException(int phoneId){
        this.phoneId = phoneId;
    }

    @Override
    public String getMessage()
    {
        return "Phone with id = " + phoneId + "not found";
    }

}
