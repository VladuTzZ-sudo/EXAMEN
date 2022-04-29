package com.example.pe_bune.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "menu_pizza")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPizza {
    @NotNull
    private Double price;

    @NotNull
    @Id
    private String pizzaType;

    @NotNull
    private Long quantity;

    //@ManyToOne(cascade = CascadeType.ALL)
    //private User user;
}
