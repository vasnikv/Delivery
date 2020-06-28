package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.entity.Stage;

public interface StagesRepository  extends JpaRepository<Stage, Long> {
}
