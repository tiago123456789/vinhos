package com.tiago.vinhos.vinhos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "vinhos")
public class Vinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoVinho tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoVinho getTipo() {
        return tipo;
    }

    public void setTipo(TipoVinho tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vinho vinho = (Vinho) o;
        return Objects.equals(id, vinho.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
