package br.com.HabitTracker.service;

import br.com.HabitTracker.entity.HabitEntity;
import br.com.HabitTracker.repository.HabitRepository;
import br.com.HabitTracker.service.contract.HabitServiceContract;
import br.com.HabitTracker.valueObject.HabitVO;
import mapper.BuildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService implements HabitServiceContract {

    private final HabitRepository repository;
    private final BuildMapper mapper = new BuildMapper();

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.repository = habitRepository;

    }

    @Override
    public HabitVO createHabit(HabitVO habitVO) {

        if (habitVO == null) {
            throw new IllegalArgumentException("Habit cannot be null");
        }
        HabitEntity habit = mapper.parseObject(new HabitEntity(), habitVO);
        HabitEntity save = repository.save(habit);
        return mapper.parseObject(new HabitVO(), save);
    }

    @Override
    public HabitVO findHabitById(String id) {

        HabitEntity habitEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("This habit was not found!!"));
        return mapper.parseObject(new HabitVO(), habitEntity);
    }
}
