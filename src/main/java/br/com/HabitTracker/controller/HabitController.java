package br.com.HabitTracker.controller;

import br.com.HabitTracker.controller.contract.HabitControllerContract;
import br.com.HabitTracker.service.HabitService;
import br.com.HabitTracker.valueObject.HabitVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<HabitVO> createHabit(HabitVO habitVO) {
        HabitVO createdHabit = habitService.createHabit(habitVO);
        return new ResponseEntity<>(createdHabit, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HabitVO> findHabitById(String id) {
        HabitVO habitById = habitService.findHabitById(id);
        return ResponseEntity.ok(habitById);
    }

    @Override
    public ResponseEntity<HabitVO> updateHabit(String id, HabitVO habitVO) {
        HabitVO updatedHabit = habitService.updateHabit(id, habitVO);
        return ResponseEntity.ok(updatedHabit);
    }

    @Override
    public ResponseEntity<Page<HabitVO>> findAllHabits(Pageable pageable) {
        Page<HabitVO> allHabits = habitService.findAllHabits(pageable);
        return ResponseEntity.ok(allHabits);
    }

    @Override
    public ResponseEntity<Void> deleteHabit(String id) {
        habitService.deleteHabit(id);
        return ResponseEntity.noContent().build();
    }
}
