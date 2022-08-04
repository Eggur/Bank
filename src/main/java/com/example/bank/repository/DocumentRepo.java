package com.example.bank.repository;

import com.example.bank.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepo extends JpaRepository<Document, Long> {

}
