package com.zxb.api_z.reposition;

import com.zxb.api_z.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByAccount_IdAndStatus(int accountID, String status);
}
