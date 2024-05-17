package com.binduit.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binduit.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
