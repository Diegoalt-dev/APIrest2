package com.empresa.prueba.services;

public class ServiceException extends Exception{
    private int statusCode;
    public ServiceException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
