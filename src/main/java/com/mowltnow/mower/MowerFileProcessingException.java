package com.mowltnow.mower;

public class MowerFileProcessingException extends RuntimeException {
    public MowerFileProcessingException(String errorMessage, Throwable err) {
        super(errorMessage,err);
    }
}
