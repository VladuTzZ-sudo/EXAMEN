package com.example.pe_bune.exceptions;

public class NoPizzaToOrderException extends Exception{
    public NoPizzaToOrderException() {
        super("There is no pizza to order. Sorry !");
    }
}
