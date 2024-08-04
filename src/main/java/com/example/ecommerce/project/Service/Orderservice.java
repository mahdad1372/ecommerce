package com.example.ecommerce.project.Service;

import com.example.ecommerce.project.Entity.Orders;
import com.example.ecommerce.project.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Orderservice {
    @Autowired
    private OrderRepository orderRepository;
    public List<Orders> getAllOrders(){
        return orderRepository.getAllOrders();
    }
    public List<Orders> getOrdersById(Integer id){
        return orderRepository.getOrdersById(id);
    }
    public void deleteOrderByOrderId(Integer id){
        orderRepository.deleteOrderByOrderId(id);
    }
    public void updateStatusById(Integer id,String status){
        orderRepository.updateStatusById(id,status);
    }
    public void updateTotalAmountById(Integer id ,Integer amount){
        orderRepository.updateTotalAmountById(id,amount);
    }

    public void addOrder(Integer user_id,Integer total_amount,String status){
        orderRepository.addOrder(user_id,total_amount,status);
    }
}

