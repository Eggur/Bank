package com.example.bank.repository;

import com.example.bank.model.PersonDocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonDocTypeRepo extends JpaRepository<PersonDocType, Long> {
    @Query("select pdt from PersonDocType pdt")
    List<PersonDocType> getDocType();
}
