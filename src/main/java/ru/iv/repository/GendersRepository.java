package ru.iv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.iv.entity.Gender;

public interface GendersRepository  extends JpaRepository<Gender, Long> {
}
