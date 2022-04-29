package com.example.pe_bune.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
public class Marguerita extends MenuPizza {
    public Marguerita(Long quantity) {
        super(10.0, String.valueOf(PizzaType.MARGUERITA), quantity);
    }
}
