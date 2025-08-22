package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String fileType;
    private int size;
    private int isArchived;
    private String path;


    
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-doc")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "folder_id")
    @JsonBackReference("folder-doc")
    private Folder folder;
    
    
    public Folder getFolder() {
        return folder;
    }
    public void setFolder(Folder folder) {
        this.folder = folder;
    }
    public Document(int id,String name,String fileType,int size,int isArchived,String path){
        this.id=id;
        this.name=name;
        this.fileType=fileType;
        this.size=size;
        this.isArchived=isArchived;
        this.path = path;
    }
    public int getId() {
        return id;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getFileType() {
        return fileType;
    }
    
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
    
    public int getIsArchived() {
        return isArchived;
    }
    
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public void setIsArchived(int isArchived) {
        this.isArchived = isArchived;
    }



    
    public Document(){

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
 
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }



    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


}
