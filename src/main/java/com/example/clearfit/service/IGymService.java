package com.example.clearfit.service;

import com.example.clearfit.model.Center;
import com.example.clearfit.model.User;
import com.example.clearfit.model.WorkOutSlot;

import java.util.List;

public interface IGymService {
    public String addWorkOutSlot(String gymName, int startTime, int endTime, String workOutName, int availability);
    public String addWorkOut(String gymName, String workOutName);
    public String addGym(String gymName);
    public List<WorkOutSlot> getWorkOutOptions(String workoutType, String gymName);
    public String bookWorkOut(String user, String gymName, int startTime, int endTime, String workOutName);
    public String cancelWorkout(String user, String gymName, int startTime, int endTime, String workOutName);

    public String addUser(String userName, String name, String emailId);
    public User getUser(String userName);
}
