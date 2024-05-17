package com.binduit.banking.service;


import java.util.List;

import com.binuit.banking.dto.AccountDto;


public interface AccountService {

   AccountDto createAccount(AccountDto account);
   AccountDto getAccountById(Long id);
   AccountDto deposit(Long id, double amount);
   AccountDto withdraw(Long id, double amount);
   List<AccountDto> getAllAccounts();
   void deleteAccount(Long id);
}
