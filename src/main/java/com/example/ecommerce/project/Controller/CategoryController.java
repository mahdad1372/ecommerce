package com.example.ecommerce.project.Controller;

import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Entity.Users;
import com.example.ecommerce.project.Service.Categoryservice;
import com.example.ecommerce.project.Service.Userservice;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private Categoryservice categoryservice;
    @PutMapping("/updatecategory")
    public void updateCategory(@RequestBody Categories categories){
        categoryservice.updatcategoryById(categories.getCategory_id(),categories.getName());
    }
    @GetMapping("/getcategory")
    public List<Categories> getCategory(){
        return categoryservice.getallCategory();
    }
    @DeleteMapping("/deletecategory")
   public void deletecategory(@RequestBody Categories categories) {
        categoryservice.deletecategorybyId(categories.getCategory_id());
    }
    @GetMapping("/getcategory/{id}")
    public List<Categories> getcategorybyId(@PathVariable("id") Integer id){
        return categoryservice.getCategoryById(id);
    }
    @PostMapping("/addcategory")
    public void postDetails(@RequestBody Categories category){
        categoryservice.addCategory(category.getName(),category.getDescription());
    }
}
