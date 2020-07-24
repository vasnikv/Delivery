package ru.iv.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.iv.delivery.entity.Client;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Client, Long> {
    @Query(value = "select c from Client c where c.name like concat('%',?1,'%')")
    List<Client> searchClientName(String name);
}
