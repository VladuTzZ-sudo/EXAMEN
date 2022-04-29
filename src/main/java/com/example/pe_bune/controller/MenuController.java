package com.example.pe_bune.controller;

import com.example.pe_bune.exceptions.NoPizzaOfThisTypeException;
import com.example.pe_bune.model.MenuPizza;
import com.example.pe_bune.model.User;
import com.example.pe_bune.service.MenuService;
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
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    @ApiOperation(value = "Get all pizza !", notes = "Returns all pizza from menu")
    public List<MenuPizza> getAll() {
        return menuService.displayAllPizza();
    }

    @PostMapping("/menu/pizza/{type}")
    @ApiOperation(value = "Add Pizza of Type to Menu!", notes = "Add pizza to menu!")
    public MenuPizza addPizzaOfTypeAndQuantity(@PathVariable(name = "type") String type,
                                                     @RequestBody Long quantity) throws NoPizzaOfThisTypeException {
        return menuService.addPizza(type, quantity);
    }
}
