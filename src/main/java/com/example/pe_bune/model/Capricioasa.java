package com.example.pe_bune.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Capricioasa extends MenuPizza {
    public Capricioasa(Long quantity) {
        super(50.0, String.valueOf(PizzaType.CAPRICIOSA), quantity);
    }
}
