package org.java.pizzeria.repo;

import org.java.pizzeria.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepo extends JpaRepository<Pizza, Integer>{

}
