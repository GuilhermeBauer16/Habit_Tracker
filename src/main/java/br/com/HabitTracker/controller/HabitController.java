package br.com.HabitTracker.controller;

import br.com.HabitTracker.controller.contract.HabitControllerContract;
import br.com.HabitTracker.service.HabitService;
import br.com.HabitTracker.valueObject.HabitVO;
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
    public ResponseEntity<HabitVO> createHabit(HabitVO habitVO) {
        HabitVO createdHabit = habitService.createHabit(habitVO);
        return new ResponseEntity<>(createdHabit, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<HabitVO> getHabitById(String id) {
        HabitVO habitById = habitService.findHabitById(id);
        return ResponseEntity.ok(habitById);
    }
}
