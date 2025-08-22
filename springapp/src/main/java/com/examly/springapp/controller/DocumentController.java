package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Document;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.DocumentRepository;
import com.examly.springapp.repository.UserRepository;
import java.util.*;


@RestController
@RequestMapping("/doc")
public class DocumentController {
    @Autowired
    private DocumentRepository docRepo;


    @Autowired
    private UserRepository useRepo;

    @PostMapping("/{id}/add")
    public Document addDocument(@PathVariable Integer id,@RequestBody Document doc){
        User use = useRepo.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        doc.setUser(use);
        return docRepo.save(doc);
    }

    @GetMapping("/get")
    public List<Document> getDocs(){
        return docRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public List<Document> getByUserId(@PathVariable int id){
        User ds = useRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("cant find id "+id));

        return ds.getDocs();
    }
 
    @DeleteMapping("/del/{id}")
    public String deleteById(@PathVariable int id){
        docRepo.deleteById(id);
        return "Deleted the particular document";
    }


}

