package com.mowltnow.mower;

public class MowerFileProcessingException extends Exception {
    public MowerFileProcessingException(String errorMessage, Throwable err) {
        super(errorMessage,err);
    }
}
