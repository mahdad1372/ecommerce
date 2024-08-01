package com.example.ecommerce.project.Repository;
import com.example.ecommerce.project.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {
    @Query(value = "SELECT s FROM Users s")
    public List<Users> getAllUsers();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Users WHERE user_id = :id")
    public void deleteUsersByUser_id(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Users SET username=?2 WHERE user_id = ?1")
    public void updateUserById(Integer id,String username);
//    @Query("select u FROM Users u WHERE u.first_name = ?1")
//     List<Users> fetchallfromcustomerswithName(String first_name);
    @Query(value="SELECT * FROM Users a WHERE a.username=?1 AND a.email=?2", nativeQuery=true)
    List<Users> fetchallfromcustomerswithName(String first_name,String email);
//
//    @Modifying
//    @Transactional
//    @Query(value = "SELECT * FROM student_db  WHERE name = :name AND st_mark = :mark ", nativeQuery = true)
//    public List<Student> logURI(@Param("mark") Integer mark, @Param("name") String name);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Users (user_id,username,password, email,first_name,last_name) values (?1,?2,?3,?4,?5,?6)",
            nativeQuery = true)
    void addUser(Integer user_id,String username,String password,String email,String first_name,String last_name);


}
