package com.example.pe_bune.model.Factory;

import com.example.pe_bune.exceptions.NoPizzaOfThisTypeException;
import com.example.pe_bune.model.*;
import com.example.pe_bune.observator.Observer;
import com.example.pe_bune.observator.Subject;

import java.util.ArrayList;
import java.util.List;

public class PizzaFactory implements Subject {
    private static PizzaFactory instance;
    private final List<Observer> observerList = new ArrayList<>();

    private PizzaFactory() {
    }

    public static PizzaFactory getInstance() {
        if (instance == null) {
            instance = new PizzaFactory();
        }
        return instance;
    }

    public MenuPizza createPizza(String type, Long quantity) throws NoPizzaOfThisTypeException {
        switch (type.toUpperCase()) {
            case "CAPRICIOSA":
                return new Capricioasa(quantity);
            case "PROSCIUTTO_FUNGHI":
                return new Prosciuto(quantity);
            case "QUATRO_STAGIONI":
                return new QuatroStagioni(quantity);
            case "MARGUERITA":
                return new Marguerita(quantity);
        }
        throw new NoPizzaOfThisTypeException();
    }

    @Override
    public void attach(Observer o) {
        if (!observerList.contains(o)) {
            System.out.println("User-ul @" + ((User) o).getName() + " subscribed the card factory.");
            observerList.add(o);
        }
    }

    @Override
    public void detach(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyUpdate(String m) {
        for (Observer o : observerList) {
            o.update(m);
        }
    }
}
