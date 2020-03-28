package com.aoher.model;

import com.aoher.model.abstracts.AbstractBean;

import javax.persistence.*;
import java.io.Serializable;

public class Endereco extends AbstractBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_endereco")
    @SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco")
    private Integer id;

    private String rua;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Override
    public Serializable getId() {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
