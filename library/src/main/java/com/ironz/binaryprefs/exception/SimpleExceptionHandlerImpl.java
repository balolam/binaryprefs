package com.ironz.binaryprefs.exception;

@SuppressWarnings("unused")
public class SimpleExceptionHandlerImpl implements ExceptionHandler {
    @Override
    public void handle(Exception e, String key) {
        e.printStackTrace();
    }
}
