package com.tiago.vinhos.vinhos.service;

import com.tiago.vinhos.vinhos.model.TipoVinho;
import com.tiago.vinhos.vinhos.repository.VinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VinhoService {

    @Autowired
    private VinhoRepository vinhoRepository;


    public TipoVinho[] getTiposDeVinho() {
        return TipoVinho.values();
    }
}
