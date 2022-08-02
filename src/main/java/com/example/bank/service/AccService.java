package com.example.bank.service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccService {

    private final AccRepository accRepository;

    public Account getAccountById(Long id){
        return accRepository.findById(id).orElseThrow(null);
    }

    public List<Account> findAll(){
        return accRepository.findAll();
    }

}
