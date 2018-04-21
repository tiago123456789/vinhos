package com.tiago.vinhos.vinhos.service;

import com.tiago.vinhos.vinhos.model.TipoVinho;
import com.tiago.vinhos.vinhos.model.Vinho;
import com.tiago.vinhos.vinhos.repository.VinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VinhoService {

    @Autowired
    private VinhoRepository vinhoRepository;

    public void salvar(Vinho vinho) {
        this.vinhoRepository.saveAndFlush(vinho);
    }

    public void deletar(Long id) {
        this.vinhoRepository.deleteById(id);
    }

    public List<Vinho> buscarTodos() {
        return this.vinhoRepository.findAll();
    }

    public Vinho buscarPorId(Long id) {
        return this.vinhoRepository.getOne(id);
    }

    public TipoVinho[] getTiposDeVinho() {
        return TipoVinho.values();
    }

}
