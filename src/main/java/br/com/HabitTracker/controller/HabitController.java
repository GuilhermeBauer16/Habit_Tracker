package br.com.HabitTracker.controller;

import br.com.HabitTracker.controller.contract.HabitControllerContract;
import br.com.HabitTracker.entity.HabitEntity;
import br.com.HabitTracker.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habit")
public class HabitController implements HabitControllerContract {

    private final HabitService habitService;

    @Autowired
    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @Override
    public ResponseEntity<HabitEntity> createHabit(HabitEntity habit) {
        HabitEntity habitEntity = habitService.createHabit(habit);
        return new ResponseEntity<>(habitEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HabitEntity> getHabitById(String id) {
        HabitEntity habitById = habitService.findHabitById(id);
        return ResponseEntity.ok(habitById);
    }
}
