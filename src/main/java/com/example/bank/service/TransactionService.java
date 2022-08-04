package com.example.bank.service;

import com.example.bank.model.Transaction;
import com.example.bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction getTransactionById(Long id){
        return transactionRepository.findById(id).orElseThrow(null);
    }

    public void saveTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }
}
