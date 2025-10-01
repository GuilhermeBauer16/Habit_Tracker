package br.com.HabitTracker.service.contract;

import br.com.HabitTracker.valueObject.HabitVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HabitServiceContract {

    HabitVO createHabit(HabitVO habitVO);

    HabitVO updateHabit(String id, HabitVO habitVO);

    HabitVO findHabitById(String id);

    Page<HabitVO> findAllHabits(Pageable pageable);

    void deleteHabit(String id);
}
