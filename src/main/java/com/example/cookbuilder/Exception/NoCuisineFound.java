package com.example.cookbuilder.Exception;

public class NoCuisineFound extends RuntimeException{
    public NoCuisineFound(String message){
        super(message);
    }
}
