package com.example.bank.controller;

import com.example.bank.model.Transaction;
import com.example.bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/transaction")
    public String transaction(){
        return "transaction";
    }

    @PostMapping("/transaction/create")
    public String createTransaction(Transaction transaction){
        transactionService.saveTransaction(transaction);
        return "redirect:/transaction";
    }
}
