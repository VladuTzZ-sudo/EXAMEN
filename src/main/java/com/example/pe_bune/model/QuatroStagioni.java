package com.example.pe_bune.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class QuatroStagioni extends MenuPizza {
    public QuatroStagioni(Long quantity) {
        super(20.0, String.valueOf(PizzaType.QUATRO_STAGIONI), quantity);
    }
}
