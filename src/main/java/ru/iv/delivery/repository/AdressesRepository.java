package ru.iv.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.delivery.entity.Address;

public interface AdressesRepository extends JpaRepository<Address, Long> {
}
