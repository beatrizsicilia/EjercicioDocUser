package com.maria.ejercicio.service.implementation;



import com.maria.ejercicio.model.Documento;
import com.maria.ejercicio.repository.DocumentRepo;
import com.maria.ejercicio.service.DocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImplementation implements DocumentService{

    @Autowired
    private DocumentRepo docRepository;

    @Override
    public Iterable<Documento> retrieveAll(){
        return docRepository.findAll();
    }
    
}
