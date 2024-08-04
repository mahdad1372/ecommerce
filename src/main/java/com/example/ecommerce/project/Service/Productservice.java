package com.example.ecommerce.project.Service;

import com.example.ecommerce.project.Entity.Products;
import com.example.ecommerce.project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Productservice {
    @Autowired
    private ProductRepository productRepository;
    public List<Products> getallproducts(){
        return productRepository.getAllproducts();
    }
    public List<Products> getProductById(Integer id){
        return productRepository.getProductsById(id);
    }
    public void deleteproductbyId(Integer id){
        productRepository.deleteProductsById(id);
    }
    public void updateproductById(Integer id,String name){
        productRepository.updateproductById(id,name);
    }

    public void addProduct(String name,String description,Integer price,Integer stock_quantity,Integer category_id){
        productRepository.addProduct(name,description,price,stock_quantity, category_id);
    }
}

