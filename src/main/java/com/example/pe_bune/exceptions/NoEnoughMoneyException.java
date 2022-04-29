package com.example.pe_bune.exceptions;

public class NoEnoughMoneyException extends Exception {
    public NoEnoughMoneyException() {
        super("You don't have enough money to buy pizza !");
    }
}
