package com.zxb.api_z;

import com.zxb.api_z.reposition.AccountRepository;
import com.zxb.api_z.reposition.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiZApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiZApplication.class, args);
    }

    @Autowired
    private AccountRepository accRepo;

    @Autowired
    private FoodRepository foodRepo;

    @Override
    public void run(String... args) throws Exception {

    }
}
