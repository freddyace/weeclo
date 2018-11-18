package com.weeclo.demo.exceptions;

public class IncorrectRequestMethodException extends Exception {

    public IncorrectRequestMethodException(){
        super();
    }

    @Override
    public String getMessage(){
        return "Incorrect request method found or the URI endpoint is incorrect....";
    }
}
