package com.zxb.api_z.reposition;

import com.zxb.api_z.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByAccount_Id(int accountID);
    List<Order> findByAccount_IdAndOrderStatus(int accountID, String status);
}
