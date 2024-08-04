package com.example.ecommerce.project.Repository;

import com.example.ecommerce.project.Entity.Categories;
import com.example.ecommerce.project.Entity.Orders;
import com.example.ecommerce.project.Entity.Products;
import com.example.ecommerce.project.Entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "SELECT s FROM Orders s")
    public List<Orders> getAllOrders();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Orders WHERE order_id = ?1")
    public void deleteOrderByOrderId(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Orders SET status=?2 WHERE order_id = ?1")
    public void updateStatusById(Integer id,String status);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Orders SET total_amount=?2 WHERE order_id = ?1")
    public void updateTotalAmountById(Integer id,Integer total_amount);

    @Query(value="SELECT * FROM Orders a WHERE a.order_id=?1", nativeQuery=true)
    List<Orders> getOrdersById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Orders (user_id,total_amount,status) values (?1,?2,?3)",
            nativeQuery = true)
    void addOrder(Integer user_id,Integer total_amount,String status);
}
