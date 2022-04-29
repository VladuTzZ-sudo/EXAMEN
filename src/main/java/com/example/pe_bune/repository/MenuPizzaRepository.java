package com.example.pe_bune.repository;

import com.example.pe_bune.model.MenuPizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPizzaRepository extends JpaRepository<MenuPizza, String> {
}
