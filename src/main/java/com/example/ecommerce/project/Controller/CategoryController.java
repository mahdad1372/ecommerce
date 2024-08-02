package com.example.ecommerce.project.Controller;

import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Entity.Users;
import com.example.ecommerce.project.Service.Categoryservice;
import com.example.ecommerce.project.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private Categoryservice categoryservice;
    @GetMapping("/getcategory")
    public List<Categories> getCategory(){
        return categoryservice.getallCategory();
    }
    @GetMapping("/getcategory/{id}")
    public List<Categories> postDetails2(@PathVariable("id") Integer id){
        return categoryservice.getCategoryById(id);
    }
}
