package com.redirect.demo.Exception;

import org.springframework.http.HttpStatus;

public class Error {
    private HttpStatus httpStatus;
    private String string;

    public Error(HttpStatus httpStatus, String string) {
        this.httpStatus = httpStatus;
        this.string = string;
    }

    public Error() {

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
