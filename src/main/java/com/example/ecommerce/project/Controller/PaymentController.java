package com.example.ecommerce.project.Controller;

import com.example.ecommerce.project.Entity.Payments;
import com.example.ecommerce.project.Entity.Products;
import com.example.ecommerce.project.Repository.PaymentRepository;
import com.example.ecommerce.project.Service.Paymentservice;
import com.example.ecommerce.project.Service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PaymentController {
    @Autowired
    private Paymentservice paymentservice;
    @PutMapping("/updatepayment")
    public void updatePayment(@RequestBody Payments payments){
        paymentservice.updatePaymentById(payments.getPayment_id(),payments.getPayment_method());
    }
    @GetMapping("/getpayments")
    public List<Payments> getpayments(){
        return paymentservice.getAllPayments();
    }
    @DeleteMapping("/deletepayments")
    public void deletepayment(@RequestBody Payments payments) {
        paymentservice.deletePaymentById(payments.getPayment_id());
    }
    @GetMapping("/getpayment/{id}")
    public List<Payments> getPaymentById(@PathVariable("id") Integer id){
        return paymentservice.getPaymentById(id);
    }
    @PostMapping("/addPayment")
    public void postDetails(@RequestBody Payments payments){
        paymentservice.addPayment(payments.getOrder_id(),payments.getPayment_method(),payments.getStatus());
    }
}
