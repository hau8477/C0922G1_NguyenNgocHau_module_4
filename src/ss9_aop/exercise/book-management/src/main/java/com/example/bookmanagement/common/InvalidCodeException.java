package com.example.bookmanagement.common;

public class InvalidCodeException extends Exception{
    public InvalidCodeException(String mess){
        super(mess);
    }
}
