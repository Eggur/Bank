package com.example.bank.controller;

import com.example.bank.model.Document;
import com.example.bank.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping("/document-register")
    public String documentRegister(Model model){
        model.addAttribute("listDocuments", documentService.listDocuments());
        return "documents";
    }

    @PostMapping("/document/create")
    public String createDocument(Document document) {
        documentService.saveDocument(document);
        return "redirect:/";
    }

    @GetMapping("/document/search")
    public String searchDocuments(@RequestParam(name = "title", required = false)String title, Model model){
        model.addAttribute("documents", documentService.listSearchDocuments(title));
        return "documents";
    }

    @GetMapping("/dict-document-type")
    public String searchDirectory(Model model){
        model.addAttribute("directory", documentService.listDocuments());
        return "doc-directory";
    }

    @GetMapping("/dict-document-type/delete{id}")
    public String deleteDocument(@PathVariable Long id){
        documentService.deleteDocument(id);
        return "redirect:/";
    }
}
