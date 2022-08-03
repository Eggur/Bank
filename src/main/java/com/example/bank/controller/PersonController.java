package com.example.bank.controller;

import com.example.bank.appuser.AppUser;
import com.example.bank.registration.RegistrationService;
import com.example.bank.service.AccService;
import com.example.bank.service.CreditCardService;
import com.example.bank.service.DocumentService;
import com.example.bank.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final DocumentService documentService;
    private final CreditCardService cardService;
    private final AccService accService;



    @GetMapping("/{id}")
    public String mainTable( Model model, @PathVariable Long id){
        model.addAttribute("acc", accService.getAccountById(id));
        return "index";
    }

    @GetMapping("/persons-search")
    public String persons(Model model){
        model.addAttribute("listPersons", personService.listPersons());
        return "persons";
    }

    @GetMapping("/person/{id}")
    public String personInfo(@PathVariable Long id, Model model){
        model.addAttribute("person", personService.getPersonById(id));
        model.addAttribute("document", documentService.getDocumentById(id));
        return "person-info";
    }

    @GetMapping("/person/delete{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return "redirect:/persons-search";
    }


}
