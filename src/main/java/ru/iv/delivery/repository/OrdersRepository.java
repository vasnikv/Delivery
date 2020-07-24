package ru.iv.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.delivery.entity.Order;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
