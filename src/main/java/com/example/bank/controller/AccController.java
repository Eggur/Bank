package com.example.bank.controller;

import com.example.bank.service.AccService;
import com.example.bank.service.CreditCardService;
import com.example.bank.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AccController {

    private final AccService accService;
    private final DocumentService documentService;
    private final CreditCardService cardService;

    @GetMapping("/acc/{id}")
    public String accInfo(@PathVariable Long id, Model model){
        model.addAttribute("acc", accService.getAccountById(id));
        model.addAttribute("document", documentService.getDocumentById(id));
        model.addAttribute("card", cardService.getCardById(id));
        return "acc";
    }



}
