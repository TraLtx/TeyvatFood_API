package com.zxb.api_z.controller;

import com.zxb.api_z.model.Account;
import com.zxb.api_z.model.Food;
import com.zxb.api_z.model.FoodOrder;
import com.zxb.api_z.reposition.AccountRepository;
import com.zxb.api_z.reposition.FoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodOrder")
public class FoodOrderController {

    @Autowired
    private FoodOrderRepository foodOrderRepo;

    @GetMapping
    public List<FoodOrder> getAll(){
        return foodOrderRepo.findAll();
    }

    @PostMapping("/add-to-cart")
    public FoodOrder addFoodOrder(@RequestBody FoodOrder foodOrder){
        return foodOrderRepo.save(foodOrder);

    }

    @PutMapping("/update")
    public FoodOrder updateFoodOrder(@RequestBody FoodOrder foodOrder){
        return foodOrderRepo.save(foodOrder);

    }

//    @DeleteMapping("/remove")
//    public void deleteFoodOrder(@RequestBody FoodOrder foodOrder){
//        foodOrderRepo.delete(foodOrder);
//    }

    @PostMapping("/remove")
    public FoodOrder deleteFoodOrder(@RequestBody FoodOrder foodOrder) {
        foodOrderRepo.delete(foodOrder);
        return foodOrder;
    }
}
