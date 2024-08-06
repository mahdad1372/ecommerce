package com.example.ecommerce.project.Service;

import com.example.ecommerce.project.Entity.Orders;
import com.example.ecommerce.project.Entity.Payments;
import com.example.ecommerce.project.Repository.OrderRepository;
import com.example.ecommerce.project.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Paymentservice {
    @Autowired
    private PaymentRepository paymentRepository;
    public List<Payments> getAllPayments(){
        return paymentRepository.getAllPayments();
    }
    public List<Payments> getPaymentById(Integer id){
        return paymentRepository.getPaymentById(id);
    }
    public void deletePaymentById(Integer id){
        paymentRepository.deletePaymentById(id);
    }
    public void updatePaymentById(Integer id,String payment_method){
        paymentRepository.updatePaymentById(id,payment_method);
    }

    public void addOrder(Integer user_id,String payment_method,String status){
        paymentRepository.addPayment(user_id,payment_method,status);
    }
}

