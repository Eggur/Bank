package com.example.bank.service;

import com.example.bank.model.*;
import com.example.bank.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepo personRepo;

    public List<Person> listPersons(){
        return personRepo.findAll();
    }

    public Person getPersonById(Long id){
        return personRepo.findById(id).orElseThrow(null);
    }

    public void deletePerson(Long id){
        personRepo.deleteById(id);
    }

}
