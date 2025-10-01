package br.com.HabitTracker.service.contract;

import br.com.HabitTracker.valueObject.HabitVO;

public interface HabitServiceContract {

    HabitVO createHabit(HabitVO habitVO);

    HabitVO findHabitById(String id);
}
