package com.example.pe_bune.controller;

import com.example.pe_bune.exceptions.NoEnoughMoneyException;
import com.example.pe_bune.exceptions.NoEnoughPizzaOfThisType;
import com.example.pe_bune.exceptions.NoPizzaOfThisTypeException;
import com.example.pe_bune.exceptions.NoPizzaToOrderException;
import com.example.pe_bune.model.User;
import com.example.pe_bune.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@AllArgsConstructor
@RequiredArgsConstructor
// @RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ApiOperation(value = "Get all users", notes = "Returns all users from application")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    @ApiOperation(value = "Get user by id", notes = "Returns user from application")
    public User getById(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    @ApiOperation(value = "Create user", notes = "Add user in the application")
    public User addUserToApplication(@RequestBody User user) {
        return userService.createOrModifyUser(user);
    }

    @PostMapping("/users/{id}/addPizza/{type}")
    @ApiOperation(value = "Want pizza!", notes = "Put pizza in cart")
    public User addPizzaToCart(@PathVariable(name = "id") Long id,
                               @PathVariable(name = "type") String type,
                               @RequestBody Long quantity) throws NoPizzaOfThisTypeException, NoEnoughPizzaOfThisType {
        return userService.addPizzaToCart(id, type, quantity);
    }

    @GetMapping("/users/{id}/pizzaOrder/")
    @ApiOperation(value = "Order pizza you want!", notes = "Buy it!")
    public User orderPizza(@PathVariable(name = "id") Long id) throws NoPizzaToOrderException, NoEnoughMoneyException {
        return userService.orderCart(id);
    }

}
