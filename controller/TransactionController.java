package com.valbonet.spring.springboot.server.banking.controller;

import com.valbonet.spring.springboot.server.banking.model.Account;
import com.valbonet.spring.springboot.server.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class TransactionController {

	public enum TransactionType	{
		DEPOSIT("deposit"), 
		WITHDRAW("withdraw");
		
		private String type;
 
		TransactionType(String value) {
			this.type = value;
		}
	 
		public String getTypeValue() {
			return type;
		}
	}
	
	

    @Autowired
    private AccountRepository accountRepository;
	
	@Autowired
    private TransactionRepository transactionRepository;
	
	
	@PutMapping("/deposit")
    public void depositMoney(@Valid @RequestBody int amount) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Account account = accountRepository.findById(userDetail.getUsername());
		account.setAmount(account.getAmount() + amount);
				
		Transaction transaction = new Transaction();
		transaction.setMail(userDetail.getUsername());.
		transaction.setTransactionType(TransactionType.DEPOSIT.getTypeValue());
		transaction.setDate(new Date());
		
		transactionRepository.save(transaction);		
       
    }
	
	@PutMapping("/withdraw")	
    public boolean withdrawMoney(@Valid @RequestBody int amount) {
		Authentication auth = SecurityContextHolder
            .getContext()
            .getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Account account = accountRepository.findById(userDetail.getUsername());
		
		if (account.getAmount() > amount){
			
			account.setAmount(account.getAmount() - amount);
			
			Transaction transaction = new Transaction();
			transaction.setMail(userDetail.getUsername());
			transaction.setTransactionType(TransactionType.WITHDRAW.getTypeValue());
			transaction.setDate(new Date());
			
			transactionRepository.save(transaction);
			return true;
		}
		
		return false;
    }
    
}