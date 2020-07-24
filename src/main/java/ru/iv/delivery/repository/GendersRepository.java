package ru.iv.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.delivery.entity.Gender;

public interface GendersRepository  extends JpaRepository<Gender, Long> {
}
