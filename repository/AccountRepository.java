package com.valbonet.spring.springboot.server.banking.repository;

import com.valbonet.spring.springboot.server.banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}