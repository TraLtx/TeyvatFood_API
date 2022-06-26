package com.zxb.api_z.controller;

import com.zxb.api_z.model.Account;
import com.zxb.api_z.reposition.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accRepo;

    @GetMapping
    public List<Account> getAllAccount(){
        return accRepo.findAll();
    }

    @PostMapping("/register")
    public Account registerAccount(@RequestBody Account acc){
        return accRepo.save(acc);
    }

    @GetMapping("/login")
    public Account login(@ModelAttribute("username") String username, @ModelAttribute("password") String password){
        return accRepo.findByUsernameAndPassword(username,password);
    }

    @GetMapping("/getAccount")
    public Account getAccount(@ModelAttribute("id") int id){
        return accRepo.findById(id);
    }

    @PutMapping("/update")
    public Account updateAccount(@RequestBody Account account){
        return accRepo.save(account);
    }
//    @GetMapping("/acc")
//    public Account login(@ModelAttribute("username") String username){
//        return accRepo.findAccountByUsername(username);
//    }
}
