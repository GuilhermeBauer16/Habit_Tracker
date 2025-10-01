package br.com.HabitTracker.controller.contract;

import br.com.HabitTracker.entity.HabitEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface HabitControllerContract {

    @PostMapping
    ResponseEntity<HabitEntity> createHabit(@RequestBody HabitEntity habit);

    @GetMapping("/{id}")
    ResponseEntity<HabitEntity> getHabitById(@PathVariable("id") String id);

}
