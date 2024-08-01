package com.example.ecommerce.project.Service;

import com.example.ecommerce.project.Entity.Users;
import com.example.ecommerce.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Userservice {
    @Autowired
    private UserRepository userRepository;
    public List<Users> fetchAll(){
        return userRepository.getAllUsers();
    }
    public List<Users> fetchstudentswithname(String name,String email){
        return userRepository.fetchallfromcustomerswithName(name,email);
    }
    public void addUser(Integer user_id,String username,String password,String email,String first_name,String last_name){
        userRepository.addUser(user_id,username,password,email,first_name,last_name);
    }
    public void deleteUserbyId(Integer id){
        userRepository.deleteUsersByUser_id(id);
    }
    public void updateUserById(Integer id,String username){
        userRepository.updateUserById(id,username);
    }
}
