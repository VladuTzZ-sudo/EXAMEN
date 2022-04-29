package com.example.pe_bune.exceptions;

public class NoEnoughPizzaOfThisType extends Exception{
    public NoEnoughPizzaOfThisType() {
        super("There is no enough pizza of the type you want !");
    }
}
