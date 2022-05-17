package com.maria.ejercicio.controller;

import com.maria.ejercicio.model.Documento;
import com.maria.ejercicio.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DocumentController {
    
    @Autowired 
    private DocumentService service;
    
    @GetMapping("/docs")
    public ResponseEntity<Iterable<Documento>> retrieveDocs(){
        return ResponseEntity.ok().body(service.retrieveAll());
    }
    
}
