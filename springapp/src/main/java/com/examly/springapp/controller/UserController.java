package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.examly.springapp.model.Document;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService useSer;

    @Autowired
    private UserRepository useRepo;

    @PostMapping("/add")
    public User addUser(@RequestBody User use){
        return useSer.addUser(use);
    }

    @GetMapping("/get")
    public List<User>getAll(){
        return useSer.getAll();
    }

    @DeleteMapping("/del/{id}")
    public String deleteUser(@PathVariable int id){
        return useSer.deleteUser(id);
    }

    @GetMapping("/get/email/{email}/{password}")
    public boolean getByUserId(@PathVariable String email,@PathVariable String password){
        User u = useRepo.findByEmail(email);
        if(u!=null){
            if(u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    @GetMapping("/get/id/{email}")
    public int getByUserId(@PathVariable String email){
        User u = useRepo.findByEmail(email);
        if(u!=null){
                return u.getId();
        }
        return -1;
    }
    
    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User use){
        User user = useRepo.findById(id) . orElseThrow(()-> new RuntimeException("Id not found"));
        user.setName(use.getName());
        user.setEmail(use.getEmail());

        return useRepo.save(user);
    }

}
