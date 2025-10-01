package br.com.HabitTracker.service;

import br.com.HabitTracker.entity.HabitEntity;
import br.com.HabitTracker.exception.FieldNotFoundException;
import br.com.HabitTracker.exception.HabitNotFoundException;
import br.com.HabitTracker.exception.InvalidHabitException;
import br.com.HabitTracker.repository.HabitRepository;
import br.com.HabitTracker.service.contract.HabitServiceContract;
import br.com.HabitTracker.utils.ValidatorUtils;
import br.com.HabitTracker.valueObject.HabitVO;
import mapper.BuildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService implements HabitServiceContract {

    private static final String HABIT_NOT_FOUND_EXCEPTION_MESSAGE = "This Habit was not found";
    private static final String INVALID_HABIT_EXCEPTION_MESSAGE = "This Habit is invalid, please verify the fields and try again";


    private final HabitRepository repository;
    private final BuildMapper mapper = new BuildMapper();
    private final ValidatorUtils validatorUtils = new ValidatorUtils();

    @Autowired
    public HabitService(HabitRepository habitRepository) {
        this.repository = habitRepository;

    }

    @Override
    public HabitVO createHabit(HabitVO habitVO) {

        validatorUtils.checkObjectIsNullOrThrowException(habitVO, INVALID_HABIT_EXCEPTION_MESSAGE, InvalidHabitException.class);
        HabitEntity habit = mapper.parseObject(new HabitEntity(), habitVO);
        HabitEntity save = repository.save(habit);
        return mapper.parseObject(new HabitVO(), save);
    }

    @Override
    public HabitVO updateHabit(String id, HabitVO habitVO) {

        HabitEntity habitEntity = repository.findById(id).orElseThrow(() -> new HabitNotFoundException(HABIT_NOT_FOUND_EXCEPTION_MESSAGE));
        HabitEntity updatedHabitEntity = validatorUtils.updateFieldIfNotNull(habitEntity, habitVO, INVALID_HABIT_EXCEPTION_MESSAGE, FieldNotFoundException.class);
        repository.save(updatedHabitEntity);
        return mapper.parseObject(new HabitVO(), updatedHabitEntity);
    }

    @Override
    public HabitVO findHabitById(String id) {

        HabitEntity habitEntity = repository.findById(id).orElseThrow(() -> new HabitNotFoundException(HABIT_NOT_FOUND_EXCEPTION_MESSAGE));
        return mapper.parseObject(new HabitVO(), habitEntity);
    }

    @Override
    public Page<HabitVO> findAllHabits(Pageable pageable) {
        Page<HabitEntity> allHabits = repository.findAll(pageable);
        List<HabitVO> habitVOS = allHabits.getContent().stream().map(habitEntity -> mapper.parseObject(new HabitVO(), habitEntity)).toList();
        return new PageImpl<>(habitVOS, pageable, allHabits.getTotalElements());
    }

    @Override
    public void deleteHabit(String id) {
        HabitEntity habitEntity = repository.findById(id).orElseThrow(() -> new HabitNotFoundException(HABIT_NOT_FOUND_EXCEPTION_MESSAGE));
        repository.delete(habitEntity);
    }
}
