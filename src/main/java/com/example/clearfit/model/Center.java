package com.example.clearfit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
public class Center {
    private final String centerName;
    private Set<String> workOutNames;
    private List<GymTime> gymTimeList;

}
