package com.example.ecommerce.project.Repository;
import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories,Integer> {
    @Query(value = "SELECT s FROM Categories s")
    public List<Users> getAllCategories();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Users WHERE user_id = :id")
    public void deleteUsersByUser_id(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Users SET username=?2 WHERE user_id = ?1")
    public void updateUserById(Integer id,String username);

    @Query(value="SELECT * FROM Users a WHERE a.username=?1 AND a.email=?2", nativeQuery=true)
    List<Users> fetchallfromcustomerswithName(String first_name,String email);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Users (user_id,username,password, email,first_name,last_name) values (?1,?2,?3,?4,?5,?6)",
            nativeQuery = true)
    void addUser(Integer user_id,String username,String password,String email,String first_name,String last_name);


}
