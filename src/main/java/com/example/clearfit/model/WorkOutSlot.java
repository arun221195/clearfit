package com.example.clearfit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class WorkOutSlot {
    private String gymName;
    private int startTime;
    private int endTime;
    private String workoutType;
    private int availablity;

    public WorkOutSlot(String gymName, int startTime, int endTime, String workoutType) {
        this.gymName = gymName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workoutType = workoutType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkOutSlot that = (WorkOutSlot) o;
        return startTime == that.startTime && endTime == that.endTime && gymName.equals(that.gymName) && workoutType.equals(that.workoutType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymName, startTime, endTime, workoutType);
    }
}
