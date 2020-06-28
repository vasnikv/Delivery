package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.entity.Dish;

public interface DishesRepository extends JpaRepository<Dish, Long> {
}
