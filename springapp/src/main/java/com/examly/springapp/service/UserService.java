package com.examly.springapp.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository useRepo;

    public User addUser(User use){
        return useRepo.save(use);
    }

    public List<User> getAll(){
        return useRepo.findAll();
    }

    public String deleteUser(int id){
        useRepo.deleteById(id);
        return "User deleted sucessfully";
    }
}
