package com.example.clearfit;

import com.example.clearfit.dao.GymDaoImpl;
import com.example.clearfit.dao.IGymDao;
import com.example.clearfit.service.GymService;
import com.example.clearfit.service.IGymService;

public class Driver {
    public void run(){
        IGymDao dao = new GymDaoImpl();
        IGymService gymService = new GymService(dao);

    }
}
