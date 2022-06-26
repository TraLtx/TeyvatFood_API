package com.zxb.api_z.controller;

import com.zxb.api_z.model.Account;
import com.zxb.api_z.model.Cart;
import com.zxb.api_z.reposition.AccountRepository;
import com.zxb.api_z.reposition.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    @GetMapping
    public List<Cart> getAll(){
        return cartRepo.findAll();
    }

    @GetMapping("/account")
    public Cart getCartByAccount(@RequestParam("id") int accountID){
        return cartRepo.findByAccount_IdAndStatus(accountID, "new");
    }

    @PostMapping("/create")
    public Cart createCart(@RequestBody Account account){
        Cart cart = new Cart();
        cart.setStatus("new");
        cart.setAccount(account);

        return cartRepo.save(cart);
    }

    @PutMapping("/ordered")
    public Cart setCartOrdered(@RequestBody Cart cart){
        return cartRepo.save(cart);
    }
}
