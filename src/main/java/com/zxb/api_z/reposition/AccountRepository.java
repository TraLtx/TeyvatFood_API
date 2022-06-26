package com.zxb.api_z.reposition;

import com.zxb.api_z.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account findById(int id);
    Account findByUsernameAndPassword(String username, String password);
    Account findAccountByUsername(String username);
}