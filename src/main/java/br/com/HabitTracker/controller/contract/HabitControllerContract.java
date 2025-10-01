package br.com.HabitTracker.controller.contract;

import br.com.HabitTracker.valueObject.HabitVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface HabitControllerContract {

    @PostMapping
    ResponseEntity<HabitVO> createHabit(@RequestBody HabitVO habitVO);

    @GetMapping("/{id}")
    ResponseEntity<HabitVO > getHabitById(@PathVariable("id") String id);

}
