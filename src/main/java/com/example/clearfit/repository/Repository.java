package com.example.clearfit.repository;

import com.example.clearfit.model.Center;
import com.example.clearfit.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Repository {
    private List<User> users= new ArrayList<>();
    private List<Center> centers= new ArrayList<>();

}
