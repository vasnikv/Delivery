package ru.iv.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.iv.delivery.entity.Position;

import java.util.List;

public interface PositionsRepository extends JpaRepository<Position, Long> {
    @Query(value = "select p from Position p where p.active = true")
    public List<Position> findOnlyActive();
}
