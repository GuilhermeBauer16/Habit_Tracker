package br.com.HabitTracker.service.contract;

import br.com.HabitTracker.entity.HabitEntity;

public interface HabitServiceContract {

    HabitEntity createHabit(HabitEntity habit);
    HabitEntity findHabitById(String id);
}
