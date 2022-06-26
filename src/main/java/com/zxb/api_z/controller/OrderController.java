package com.zxb.api_z.controller;

import com.zxb.api_z.model.Order;
import com.zxb.api_z.reposition.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @GetMapping
    public List<Order> getAll(){
        return orderRepo.findAll();
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order){
        return orderRepo.save(order);
    }

    @GetMapping("/forAccount")
    public List<Order> getHistoryOrder(@RequestParam("accountID") int accountID){
        return orderRepo.findByAccount_Id(accountID);
    }
    @GetMapping("/forAccountStatus")
    public List<Order> getHistoryOrderWithStatus(@RequestParam("accountID") int accountID, @RequestParam("status") String status){
        return orderRepo.findByAccount_IdAndOrderStatus(accountID,status);
    }

}
