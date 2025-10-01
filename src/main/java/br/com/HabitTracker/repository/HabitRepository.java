package br.com.HabitTracker.repository;

import br.com.HabitTracker.entity.HabitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<HabitEntity, String> {
}
