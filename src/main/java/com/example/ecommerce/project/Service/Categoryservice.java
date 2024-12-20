package com.example.ecommerce.project.Service;

import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Categoryservice {
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Categories> getallCategory(){
        return categoryRepository.getAllCategories();
    }
    public List<Categories> getCategoryById(Integer id){
        return categoryRepository.getCategoriesByCategory_id(id);
    }
    public void deletecategorybyId(Integer id){
        categoryRepository.deleteCategoriesByid(id);
    }
    public void updatcategoryById(Integer id,String name){
        categoryRepository.updatecategorybyId(id,name);
    }

    public void addCategory(Integer category_id ,String name,String description){
        categoryRepository.addcategory(category_id,name,description);
    }
}
