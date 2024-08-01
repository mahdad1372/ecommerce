package com.example.ecommerce.project.Controller;
import com.example.ecommerce.project.Entity.Users;
import com.example.ecommerce.project.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private Userservice userservice;
    @PutMapping("/updateuser/username")
    public void updateuser(@RequestBody Users user){
        userservice.updateUserById(user.getUser_id(),user.getUsername());
    }
    @DeleteMapping("/deleteuser")
    public void deleteuser(@RequestBody Users user){
        userservice.deleteUserbyId(user.getUser_id());
    }
    @GetMapping("/getUser")
    public List<Users> getStudents(){
        return userservice.fetchAll();
    }

    @GetMapping("/GETUser")
    public List<Users> addStudents(@RequestBody Users users ){
        String f_name = users.getFirst_name();
        String email = users.getEmail();
        return userservice.fetchstudentswithname(f_name,email);
    }
    @PostMapping("/addUser")
    public void postDetails(@RequestBody Users users){
        userservice.addUser(users.getUser_id(),users.getUsername(),users.getPassword(),users.getEmail(),users.getFirst_name(),users.getLast_name());
    }

}

