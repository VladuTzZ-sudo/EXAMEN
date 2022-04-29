package com.example.pe_bune.service;

import com.example.pe_bune.exceptions.NoEnoughMoneyException;
import com.example.pe_bune.exceptions.NoEnoughPizzaOfThisType;
import com.example.pe_bune.exceptions.NoPizzaOfThisTypeException;
import com.example.pe_bune.exceptions.NoPizzaToOrderException;
import com.example.pe_bune.model.Cart;
import com.example.pe_bune.model.Factory.PizzaFactory;
import com.example.pe_bune.model.MenuPizza;
import com.example.pe_bune.model.Order;
import com.example.pe_bune.model.User;
import com.example.pe_bune.repository.CartRepository;
import com.example.pe_bune.repository.MenuPizzaRepository;
import com.example.pe_bune.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    MenuService menuService;

    public User createOrModifyUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    public User addPizzaToCart(Long id, String type, Long quantity) throws NoPizzaOfThisTypeException, NoEnoughPizzaOfThisType {
        User user = userRepository.getById(id);
        MenuPizza pizza = PizzaFactory.getInstance().createPizza(type, quantity);

        Cart cart = user.getCart();
        cart.setCartNumberOfPizza(cart.getCartNumberOfPizza() + 1);
        cart.setCartTotalPrice(cart.getCartTotalPrice() + quantity * pizza.getPrice());

        Long quantityFromMenu =  menuService.getQuantityOfPizzaType(type);
        if (quantityFromMenu < quantity ){
            throw new NoEnoughPizzaOfThisType();
        }

        for (int i = 0; i < quantity; i++ ) {
            user.getCart().getPizzaList().add(pizza);
        }

        cartRepository.save(cart);
        return userRepository.save(user);
    }

    public User orderCart(Long id) throws NoPizzaToOrderException, NoEnoughMoneyException {
        User user = userRepository.getById(id);
        Cart cart = user.getCart();

        if (cart.getCartNumberOfPizza() == 0 ){
            throw new NoPizzaToOrderException();
        }

        if (user.getMoney() < cart.getCartTotalPrice()) {
            throw new NoEnoughMoneyException();
        }else {
            user.setMoney(user.getMoney() - cart.getCartTotalPrice());
        }

        user.getOrders().add(new Order(Calendar.getInstance().getTime()));

        cart.reinitializeCart();
        return userRepository.save(user);
    }
}
