package com.example.pe_bune.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Prosciuto extends MenuPizza {
    public Prosciuto(Long quantity) {
        super(30.0, String.valueOf(PizzaType.PROSCIUTTO_FUNGHI), quantity);
    }
}
