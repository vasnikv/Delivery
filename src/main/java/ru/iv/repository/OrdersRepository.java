package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.entity.Order;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
