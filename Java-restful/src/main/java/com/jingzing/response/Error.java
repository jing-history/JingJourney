package com.jingzing.response;

import java.util.List;

/**
 * Created by Louis Wang on 2016/5/20.
 */

public class Error {
    private String message;
    private List<Stack> errors;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Stack> getErrors() {
        return errors;
    }

    public void setErrors(List<Stack> errors) {
        this.errors = errors;
    }
}
