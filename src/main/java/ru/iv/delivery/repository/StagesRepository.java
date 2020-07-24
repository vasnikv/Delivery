package ru.iv.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.delivery.entity.Stage;

public interface StagesRepository  extends JpaRepository<Stage, Long> {
}
