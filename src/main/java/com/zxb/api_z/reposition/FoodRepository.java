package com.zxb.api_z.reposition;

import com.zxb.api_z.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    Food findById(int id);
    List<Food> findByCountry(String suggest);
    List<Food> findByFtype(String type);
    List<Food> findByFnameContaining(String key);

}
