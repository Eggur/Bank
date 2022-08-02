package com.example.bank.repository;

import com.example.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccRepository extends JpaRepository<Account, Long> {
}
