package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.entity.Address;

public interface AdressesRepository extends JpaRepository<Address, Long> {
}
