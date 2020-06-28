package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.entity.Client;

public interface ClientsRepository extends JpaRepository<Client, Long> {
}
