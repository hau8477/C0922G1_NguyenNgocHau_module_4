package com.example.bookmanagement.common;

public class OutOfBookException extends Exception{
    public OutOfBookException(String mess){
        super(mess);
    }
}
