package com.zxb.api_z.reposition;

import com.zxb.api_z.model.Food;
import com.zxb.api_z.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}
