package com.tiago.vinhos.vinhos.service;

import com.tiago.vinhos.vinhos.exception.NegocioException;
import com.tiago.vinhos.vinhos.model.TipoVinho;
import com.tiago.vinhos.vinhos.model.Vinho;
import com.tiago.vinhos.vinhos.repository.VinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VinhoService {

    @Autowired
    private VinhoRepository vinhoRepository;

    public void salvar(Vinho vinho) {
        this.vinhoRepository.saveAndFlush(vinho);
    }

    public Vinho buscarPorId(Long id) {
        return this.vinhoRepository.getOne(id);
    }

    public TipoVinho[] getTiposDeVinho() {
        return TipoVinho.values();
    }

}
