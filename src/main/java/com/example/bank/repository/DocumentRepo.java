package com.example.bank.repository;

import com.example.bank.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentRepo extends JpaRepository<Document, Long> {
    @Query("select d from Document d where ?1 is null or d.title like ?1")
    List<Document> findByTitleDocument(String titleDocument);

    @Query("select d from Document d where ?1 is null or d.title like ?1 and " +
            "( ?1 is null or d.numeral like ?2)")
    List<Document> findByTitleDocument2(String titleDocument, String numeral);

    @Query("select d from Document d " +
            "left join PersonDocType pdt where d.typeCode=pdt.code")
    List<Document> allDocuments();
}
