package br.com.HabitTracker.service;

import br.com.HabitTracker.entity.HabitEntity;
import br.com.HabitTracker.repository.HabitRepository;
import br.com.HabitTracker.service.contract.HabitServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService implements HabitServiceContract {

    private final HabitRepository repository;

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.repository = habitRepository;
    }

    @Override
    public HabitEntity createHabit(HabitEntity habit) {

        return repository.save(habit);
    }

    @Override
    public HabitEntity findHabitById(String id) {

        HabitEntity habitEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("This habit was not found!!"));
        return habitEntity;
    }
}
