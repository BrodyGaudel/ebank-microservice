package com.brodygaudel.customerservice.exceptions;

public class CommandRejectedException extends Exception{
    public CommandRejectedException(String message) {
        super(message);
    }
}
