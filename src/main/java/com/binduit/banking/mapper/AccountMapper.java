package com.binduit.banking.mapper;

import com.binduit.banking.entity.Account;
import com.binuit.banking.dto.AccountDto;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDto accountDto)
	{
		Account account = new Account(
				accountDto.getId(),
				accountDto.getAccountHolderName(),
				accountDto.getBalance()
					);
		return account;
		
		
	}

	
	public static AccountDto mapToAccountDTO(Account account){
		
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getSalary()
			);
				
	return accountDto;
}
	
}
