package com.binduit.banking.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.binduit.banking.entity.Account;
import com.binduit.banking.mapper.AccountMapper;
import com.binduit.banking.repository.AccountRepository;
import com.binuit.banking.dto.AccountDto;

@Service
public class AccountServiceImpl implements AccountService{
	
	
	private AccountRepository accountRepository;
	
	
	

	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}




	@Override
	public AccountDto createAccount(AccountDto accountDto) {
	Account account =	AccountMapper.mapToAccount(accountDto);
	Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDTO(savedAccount);
	}




	@Override
	public AccountDto getAccountById(Long id) {
	Account account =	accountRepository
			.findById(id)
			.orElseThrow(()-> new RuntimeException("Account doesn't exist"));
		return AccountMapper.mapToAccountDTO(account);
	}




	@Override
	public AccountDto deposit(Long id, double amount) {
	Account account =	accountRepository.findById(id)
		.orElseThrow(() -> new RuntimeException("Account doesn't exists"));
		
	double total = account.getSalary() + amount;
	account.setSalary(total);
    Account savedAccount = accountRepository.save(account); //convert jpa data to account DTO
	
	return AccountMapper.mapToAccountDTO(savedAccount);
	}




	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("Account does not exist") );
		
		if(account.getSalary()< amount)
		{
			throw new RuntimeException("Insufficient Balance");
		}
		double total = account.getSalary()- amount;
		account.setSalary(total);
		Account savedAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDTO(savedAccount);
	}




	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();		
	return accounts.stream().map((account) -> AccountMapper.mapToAccountDTO(account))
		.collect(Collectors.toList());
		
	}




	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository
		.findById(id)
		.orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		accountRepository.deleteById(id);
		
	}
	

}
