package com.example.ecommerce.project.Repository;
import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories,Integer> {
    @Query(value = "SELECT s FROM Categories s")
    public List<Categories> getAllCategories();
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Categories WHERE category_id = :id")
    public void deleteCategoriesByid(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Categories SET name=?2 WHERE category_id = ?1")
    public void updateUserById(Integer id,String name);

    @Query(value="SELECT * FROM Categories a WHERE a.category_id=:id", nativeQuery=true)
    List<Categories> getCategoriesByCategory_id(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Categories (category_id,name,description) values (?1,?2,?3)",
            nativeQuery = true)
    void addUser(Integer category_id,String name,String description);
}
