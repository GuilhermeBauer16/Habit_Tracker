package br.com.HabitTracker.valueObject;

import br.com.HabitTracker.enums.FrequencyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class HabitVO {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private FrequencyType frequencyType;
    private boolean active;


    public HabitVO() {
    }

    public HabitVO(String id, String name, String description, LocalDate startDate, LocalDate endDate, FrequencyType frequencyType, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequencyType = frequencyType;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public FrequencyType getFrequencyType() {
        return frequencyType;
    }

    public void setFrequencyType(FrequencyType frequencyType) {
        this.frequencyType = frequencyType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}



