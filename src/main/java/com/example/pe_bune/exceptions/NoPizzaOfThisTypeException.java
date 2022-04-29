package com.example.pe_bune.exceptions;

public class NoPizzaOfThisTypeException extends Exception {
    public NoPizzaOfThisTypeException() {
        super("There is no pizza of the type you want !");
    }
}
