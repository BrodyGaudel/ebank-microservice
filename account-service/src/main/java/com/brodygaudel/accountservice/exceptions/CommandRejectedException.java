package com.brodygaudel.accountservice.exceptions;

public class CommandRejectedException extends Exception{
    public CommandRejectedException(String message) {
        super(message);
    }
}
