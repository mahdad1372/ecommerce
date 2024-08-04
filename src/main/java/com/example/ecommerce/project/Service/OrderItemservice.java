package com.example.ecommerce.project.Service;

import com.example.ecommerce.project.Entity.OrderItem;
import com.example.ecommerce.project.Entity.Orders;
import com.example.ecommerce.project.Repository.OrderItemRepository;
import com.example.ecommerce.project.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemservice {
    @Autowired
    private OrderItemRepository orderItemRepository;
    public List<OrderItem> getAllOrderItems(){
        return orderItemRepository.getAllOrderItems();
    }
    public List<OrderItem> getOrderItemById(Integer id){
        return orderItemRepository.getOrderItemById(id);
    }
    public void deleteOrderItemById(Integer id){
        orderItemRepository.deleteOrderItemById(id);
    }
    public void updateQuantityById(Integer id,Integer quantity){
        orderItemRepository.updateQuantityById(id,quantity);
    }
    public void updatePriceById(Integer id ,Integer price){
        orderItemRepository.updatePriceById(id,price);
    }

    public void addOrderItem(Integer order_id,Integer product_id,Integer quantity,Integer price){
        orderItemRepository.addOrderItem(order_id,product_id,quantity,price);
    }
}
