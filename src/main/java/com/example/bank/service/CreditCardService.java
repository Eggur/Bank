package com.example.bank.service;

import com.example.bank.model.CreditCard;
import com.example.bank.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardRepository cardRepository;

    public List<CreditCard> listCards(){
        return cardRepository.findAll();
    }

    public CreditCard getCardById(Long id){
        return cardRepository.findById(id).orElseThrow(null);
    }

    public void saveCard(CreditCard creditCard){
        cardRepository.save(creditCard);
    }

    public void deleteCard(Long id){
        cardRepository.deleteById(id);
    }


}
