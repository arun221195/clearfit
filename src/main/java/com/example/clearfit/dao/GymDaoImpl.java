package com.example.clearfit.dao;

import com.example.clearfit.model.BookedSlot;
import com.example.clearfit.model.Center;
import com.example.clearfit.model.User;
import com.example.clearfit.model.WorkOutSlot;

import java.util.*;
import java.util.stream.Collectors;

public class GymDaoImpl implements IGymDao {
    private static Map<String, User> users= new HashMap<>();
    private static Map<String, Center> centers= new HashMap<>();
    private static List<WorkOutSlot> workOutSlots= new ArrayList<>();
    private static Set<BookedSlot> bookedSlots= new HashSet<>();
    @Override
    public void addWorkOutSlot(String gymName, int startTime, int endTime, String workOutName, int availability) {
       workOutSlots.add(new WorkOutSlot(gymName, startTime, endTime, workOutName, availability));
    }

    @Override
    public void addWorkOut(String gymName, String workOutName) {
        centers.get(gymName).getWorkOutNames().add(workOutName);
    }

    @Override
    public void addGym(String gymName) {
        centers.put(gymName, new Center(gymName, new HashSet<>(), new ArrayList<>()));
    }

    @Override
    public Center getGym(String gymName) {
        return centers.get(gymName);
    }

    @Override
    public List<WorkOutSlot> getWorkOutOptions(String workoutType, String gymName) {
        List<WorkOutSlot> result = workOutSlots.stream().toList();
        if(gymName != null) {
            result = result.stream().filter(workOutSlot -> workOutSlot.getWorkoutType().equals(workoutType)).collect(Collectors.toList());
        }
        if(workoutType != null) {
            result = result.stream().filter(workOutSlot -> workOutSlot.getGymName().equals(gymName)).collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public void bookWorkOut(String user, String gymName, int startTime, int endTime, String workOutName) {
        bookedSlots.add(new BookedSlot(user, gymName, startTime, endTime, workOutName));
        WorkOutSlot workOutSlotToUpdate = new WorkOutSlot(gymName, startTime, endTime, workOutName);
        workOutSlots.stream().filter(workOutSlot -> workOutSlot.equals(workOutSlotToUpdate)).forEach(workOutSlot -> workOutSlot.setAvailablity(workOutSlotToUpdate.getAvailablity() - 1));
    }

    @Override
    public List<BookedSlot> getBookWorkOut(String user, String gymName, int startTime, int endTime, String workOutName) {
        BookedSlot bookedSlotToSearch = new BookedSlot(user, gymName, startTime, endTime, workOutName);
        return bookedSlots.stream().filter(workOutSlot -> workOutSlot.equals(bookedSlotToSearch)).collect(Collectors.toList());
    }

    @Override
    public List<WorkOutSlot> getWorkOut(String gymName, int startTime, int endTime, String workOutName) {
        WorkOutSlot workOutSlotToUpdate = new WorkOutSlot(gymName, startTime, endTime, workOutName);
        return workOutSlots.stream().filter(workOutSlot -> workOutSlot.equals(workOutSlotToUpdate)).collect(Collectors.toList());
    }

    @Override
    public void cancelWorkout(String user, String gymName, int startTime, int endTime, String workOutName) {
        bookedSlots.remove(new BookedSlot(user, gymName, startTime, endTime, workOutName));
        WorkOutSlot workOutSlotToUpdate = new WorkOutSlot(gymName, startTime, endTime, workOutName);
        workOutSlots.stream().filter(workOutSlot -> workOutSlot.equals(workOutSlotToUpdate)).forEach(workOutSlot -> workOutSlot.setAvailablity(workOutSlotToUpdate.getAvailablity() + 1));

    }

    @Override
    public void addUser(String userName, String name, String emailId) {
        users.put(userName, new User(userName, name, emailId));
    }

    @Override
    public User getUser(String userName) {
        return users.get(userName);
    }
}
