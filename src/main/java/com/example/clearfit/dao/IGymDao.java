package com.example.clearfit.dao;

import com.example.clearfit.model.BookedSlot;
import com.example.clearfit.model.Center;
import com.example.clearfit.model.User;
import com.example.clearfit.model.WorkOutSlot;

import java.util.List;

public interface IGymDao {
    public void addWorkOutSlot(String gymName, int startTime, int endTime, String workOutName, int availability);
    public void addWorkOut(String gymName, String workOutName);
    public void addGym(String gymName);
    public Center getGym(String gymName);
    public List<WorkOutSlot> getWorkOutOptions(String workoutType, String gymName);
    public void bookWorkOut(String user, String gymName, int startTime, int endTime, String workOutName);

    List<BookedSlot> getBookWorkOut(String user, String gymName, int startTime, int endTime, String workOutName);

    List<WorkOutSlot> getWorkOut(String gymName, int startTime, int endTime, String workOutName);

    public void cancelWorkout(String user, String gymName, int startTime, int endTime, String workOutName);

    public void addUser(String userName, String name, String emailId);
    public User getUser(String userName);

}
