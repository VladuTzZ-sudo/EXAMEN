package com.example.pe_bune.service;

import com.example.pe_bune.exceptions.NoPizzaOfThisTypeException;
import com.example.pe_bune.model.Factory.PizzaFactory;
import com.example.pe_bune.model.MenuPizza;
import com.example.pe_bune.repository.MenuPizzaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class MenuService {
    @Autowired
    MenuPizzaRepository menuPizzaRepository;

    public List<MenuPizza> displayAllPizza() {
        return menuPizzaRepository.findAll();
    }

    public MenuPizza addPizza(String type, Long quantity) throws NoPizzaOfThisTypeException {
        PizzaFactory pizzaFactory = PizzaFactory.getInstance();

        if (type.toUpperCase().compareTo("CAPRICIOASA") != 0 && type.toUpperCase().compareTo("MARGUERITA") != 0 && type.toUpperCase().compareTo("PROSCIUTTO_FUNGHI") != 0 && type.toUpperCase().compareTo("QUATRO_STAGIONI") != 0) {
            throw new NoPizzaOfThisTypeException();
        }

        Optional<MenuPizza> pizzais = menuPizzaRepository.findById(type);
        if (pizzais.isPresent()) {
            pizzais.get().setQuantity(pizzais.get().getQuantity() + quantity);
            return pizzais.get();
        }

        MenuPizza pizza = pizzaFactory.createPizza(type, quantity);
        pizza.setQuantity(quantity);

        return menuPizzaRepository.save(pizza);
    }

    public Long getQuantityOfPizzaType(String type) throws NoPizzaOfThisTypeException {
        if (type.toUpperCase().compareTo("CAPRICIOASA") != 0 && type.toUpperCase().compareTo("MARGUERITA") != 0 && type.toUpperCase().compareTo("PROSCIUTTO_FUNGHI") != 0 && type.toUpperCase().compareTo("QUATRO_STAGIONI") != 0) {
            throw new NoPizzaOfThisTypeException();
        }

        Optional<MenuPizza> pizzais = menuPizzaRepository.findById(type);
        if (pizzais.isPresent()) {
            return pizzais.get().getQuantity();
        }

        throw new NoPizzaOfThisTypeException();
    }
}
