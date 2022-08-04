package com.example.bank.controller;

import com.example.bank.model.Account;
import com.example.bank.model.CreditCard;
import com.example.bank.service.AccService;
import com.example.bank.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardService cardService;
    private final AccService accService;

    @GetMapping("/credit-card")
    public String creditCard(Model model){
        model.addAttribute("acc", accService.findAll());
        return "cards";
    }

    @PostMapping("/credit-card/create")
    public String createCard(@ModelAttribute("card") CreditCard creditCard){
        cardService.saveCard(creditCard);
        return "redirect:/credit-card";
    }

    @GetMapping("/credit-card/delete{id}")
    public String deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
        return "redirect:/credit-card";
    }


}
