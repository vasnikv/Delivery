package ru.iv.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.delivery.entity.Dish;

public interface DishesRepository extends JpaRepository<Dish, Long> {
}
