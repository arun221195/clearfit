package com.example.clearfit.service;

import com.example.clearfit.dao.IGymDao;
import com.example.clearfit.model.BookedSlot;
import com.example.clearfit.model.Center;
import com.example.clearfit.model.User;
import com.example.clearfit.model.WorkOutSlot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GymService implements IGymService {
    IGymDao dao;
    public GymService(IGymDao dao){
        this.dao = dao;
    }

    @Override
    public String addWorkOutSlot(String gymName, int startTime, int endTime, String workOutName, int availability) {
        Center center = dao.getGym(gymName);
        if(center == null) {
            System.out.println("No Gym found with name");
            return "No Gym found with name";
        }
        if(!center.getWorkOutNames().contains(workOutName)){
            System.out.println("Gym Doesn't have this workout");
            return "Gym Doesn't have this workout";
        }
        dao.addWorkOutSlot(gymName, startTime, endTime, workOutName, availability);
        return "Succesffully addded workout slot";
    }

    @Override
    public String addWorkOut(String gymName, String workOutName) {
        Center center = dao.getGym(gymName);
        if(center == null) {
            System.out.println("No Gym found with name");
            return "No Gym found with name";
        }
        dao.addWorkOut(gymName, workOutName);
        return "Successfully added workout type";
    }

    @Override
    public String addGym(String gymName) {
        dao.addGym(gymName);
        return "Successfully added Gym";
    }

    @Override
    public List<WorkOutSlot> getWorkOutOptions(String workoutType, String gymName) {
        List<WorkOutSlot> result = dao.getWorkOutOptions(workoutType, gymName);
        if(gymName == null){
            Comparator comparator = (Comparator<WorkOutSlot>) (o1, o2) -> o1.getAvailablity() >= o2.getAvailablity() ? 1 : -1;
            Collections.sort(result, comparator);
        } else {
            Comparator comparator = (Comparator<WorkOutSlot>) (o1, o2) -> o1.getStartTime() >= o2.getStartTime() ? 1 : -1;
            Collections.sort(result, comparator);
        }
        return result;
    }

    @Override
    public synchronized String bookWorkOut(String user, String gymName, int startTime, int endTime, String workOutName) {
        List<WorkOutSlot> workOutSlot = dao.getWorkOutOptions(gymName, workOutName);
        if(workOutSlot.isEmpty()){
            return "No such workout";
        }
        if(workOutSlot.get(0).getAvailablity() == 0){
            return "ALl slot are filled";
        }
        dao.bookWorkOut(user, gymName, startTime, endTime, workOutName);
        return "Successfully booked";
    }

    @Override
    public synchronized String cancelWorkout(String user, String gymName, int startTime, int endTime, String workOutName) {
        List<BookedSlot> bookedSlot = dao.getBookWorkOut(user, gymName, startTime, endTime, workOutName);
        if(bookedSlot.isEmpty()){
            return "Nothign to cancel";
        }
        dao.cancelWorkout(user, gymName, startTime, endTime, workOutName);
        return "SuccessFull cancelled";
    }

    @Override
    public String addUser(String userName, String name, String emailId) {
        dao.addUser(userName, name, emailId);
        return "Successfully added user";
    }

    @Override
    public User getUser(String userName) {
        return dao.getUser(userName);
    }
}
