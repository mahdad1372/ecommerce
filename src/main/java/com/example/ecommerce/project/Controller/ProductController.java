package com.example.ecommerce.project.Controller;

import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Entity.Products;
import com.example.ecommerce.project.Service.Categoryservice;
import com.example.ecommerce.project.Service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
    @Autowired
    private Productservice productservice;
    @PutMapping("/updateProduct")
    public void updateCategory(@RequestBody Products products){
        productservice.updateproductById(products.getProduct_id(),products.getName());
    }
    @GetMapping("/getproducts")
    public List<Products> getproducts(){
        return productservice.getallproducts();
    }
    @DeleteMapping("/deleteproducts")
    public void deleteproduct(@RequestBody Products products) {
        productservice.deleteproductbyId(products.getProduct_id());
    }
    @GetMapping("/getcategory/{id}")
    public List<Products> getcategorybyId(@PathVariable("id") Integer id){
        return productservice.getProductById(id);
    }
    @PostMapping("/addProduct")
    public void postDetails(@RequestBody Products products){
        productservice.addProduct(products.getName(),products.getDescription(),products.getPrice(),
                products.getCategory_id());
    }
}
