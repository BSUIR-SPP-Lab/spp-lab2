package com.belykh.lab2.exception;

/**
 * Created by panda on 16.11.17.
 */
public class ServiceException extends Exception {
    public ServiceException() {
    }

    public ServiceException(String s) {
        super(s);
    }

    public ServiceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }
}
