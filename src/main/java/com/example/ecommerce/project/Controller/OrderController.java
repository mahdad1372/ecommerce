package com.example.ecommerce.project.Controller;
import com.example.ecommerce.project.Entity.Orders;
import com.example.ecommerce.project.Service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class OrderController {
    @Autowired
    private Orderservice orderservice;
    @PutMapping("/updateorder/status")
    public void updateOrder(@RequestBody Orders orders){
        orderservice.updateStatusById(orders.getOrder_id(),orders.getStatus());
    }
    @PutMapping("/updateorder/amount")
    public void updateOrderAmount(@RequestBody Orders orders){
        orderservice.updateTotalAmountById(orders.getOrder_id(),orders.getTotal_amount());
    }
    @GetMapping("/getorders")
    public List<Orders> getOrders(){
        return orderservice.getAllOrders();
    }
    @DeleteMapping("/deleteorder/{id}")
    public void deleteOrderById(@PathVariable("id") Integer id) {
        orderservice.deleteOrderByOrderId(id);
    }
//    @GetMapping("/getproduct/{id}")
//    public List<Orders> getcategorybyId(@PathVariable("id") Integer id){
//        return orderservice.getOrdersById(id);
//    }
    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Orders orders){
        orderservice.addOrder(orders.getUser_id(),orders.getTotal_amount(),orders.getStatus());
    }
}
