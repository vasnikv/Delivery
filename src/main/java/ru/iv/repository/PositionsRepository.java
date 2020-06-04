package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.entity.Position;

public interface PositionsRepository extends JpaRepository<Position, Long> {
}
