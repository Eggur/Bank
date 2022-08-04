package com.example.bank.service;

import com.example.bank.model.Document;
import com.example.bank.repository.DocumentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepo documentRepository;

    public List<Document> listDocuments() {
        return documentRepository.findAll();
        //       return documentRepository.allDocuments();
    }

    public void saveDocument(Document document) {
        log.info("Saving new {}", document);
        documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }
}
