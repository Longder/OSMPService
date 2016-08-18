package com.microdata.osmpservice.exception;

/**
 * PMS自定义异常
 * Created by Longder on 2016/8/17.
 */
public class PMSException extends RuntimeException{
    public PMSException() {
    }

    public PMSException(String message) {
        super(message);
    }

    public PMSException(String message, Throwable cause) {
        super(message, cause);
    }

    public PMSException(Throwable cause) {
        super(cause);
    }
}
