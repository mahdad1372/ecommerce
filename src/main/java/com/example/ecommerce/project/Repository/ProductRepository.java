package com.example.ecommerce.project.Repository;

import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Entity.Products;
import com.example.ecommerce.project.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Integer> {
    @Query(value = "SELECT s FROM Products s")
    public List<Products> getAllproducts();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Products WHERE product_id = :id")
    public void deleteProductsById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Products SET name=?2 WHERE product_id = ?1")
    public void updateproductById(Integer id,String name);

    @Query(value="SELECT * FROM Products a WHERE a.product_id=?1", nativeQuery=true)
    List<Products> getProductsById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Products (name,description,price,stock_quantity, category_id) values (?1,?2,?3,?4,?5)",
            nativeQuery = true)
    void addProduct(String name,String description,Integer price,Integer stock_quantity,Integer category_id);
}
