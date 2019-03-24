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
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
	
	
	@GetMapping("/balance")
    public int getAccountBalance() {
		Authentication auth = SecurityContextHolder
            .getContext()
            .getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Account account = accountRepository.findById(userDetail.getUsername());
        return account.getAmount();
    }
	
	
    @GetMapping("/statement")
    public String getAccountStatement() {
		Authentication auth = SecurityContextHolder
            .getContext()
            .getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Account account = accountRepository.findById(userDetail.getUsername());
        return account.getStatement();
    }
}