package com.example.clearfit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class GymTime {
    private String startTime;
    private String endTime;
}
