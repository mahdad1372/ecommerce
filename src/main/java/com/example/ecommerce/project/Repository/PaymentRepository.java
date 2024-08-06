package com.example.ecommerce.project.Repository;
import com.example.ecommerce.project.Entity.Payments;
import com.example.ecommerce.project.Entity.Products;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payments,Integer> {
    @Query(value = "SELECT s FROM Payments s")
    public List<Payments> getAllPayments();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Payments WHERE payment_id = :id")
    public void deletePaymentById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Payments SET payment_method=?2 WHERE payment_id = ?1")
    public void updatePaymentById(Integer id,String payment_method);

    @Query(value="SELECT * FROM Payments a WHERE a.payment_id=?1", nativeQuery=true)
    List<Payments> getPaymentById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Payments (order_id,payment_method,status) values (?1,?2,?3)",
            nativeQuery = true)
    void addPayment(Integer order_id,String payment_method,String status);
}
