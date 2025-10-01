package br.com.HabitTracker.controller.contract;

import br.com.HabitTracker.valueObject.HabitVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface HabitControllerContract {

    @PostMapping
    ResponseEntity<HabitVO> createHabit(@RequestBody HabitVO habitVO);

    @GetMapping("/{id}")
    ResponseEntity<HabitVO> findHabitById(@PathVariable("id") String id);

    @PutMapping("/updateHabit/{id}")
    ResponseEntity<HabitVO> updateHabit(@PathVariable("id") String id, @RequestBody HabitVO habitVO);

    @GetMapping
    ResponseEntity<Page<HabitVO>> findAllHabits(Pageable pageable);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteHabit(@PathVariable("id") String id);

}
