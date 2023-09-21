package com.example.clearfit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class BookedSlot {
    private String userName;
    private String gymName;
    private int startTime;
    private int endTime;
    private String workoutType;

}
