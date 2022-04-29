package com.example.pe_bune.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cart_pizza")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Cart {
    @Id
    @Column(name = "cart_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private Double cartTotalPrice;
    private Integer cartNumberOfPizza;

    @OneToOne
    private User user;

    @OneToMany
    List<MenuPizza> pizzaList;

    public void reinitializeCart() {
        cartTotalPrice = 0.0;
        cartNumberOfPizza = 0;
        pizzaList.clear();
    }
}
