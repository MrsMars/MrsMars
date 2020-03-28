package com.aoher.model;

import com.aoher.model.abstracts.AbstractBean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Pessoa extends AbstractBean implements Serializable {

    private static final long serialVersionUID = 125113693073535671L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pessoa")
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> listEndereco;

    @Override
    public Serializable getId() {
        return null;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Endereco> getListEndereco() {
        return listEndereco;
    }

    public void setListEndereco(List<Endereco> listEndereco) {
        this.listEndereco = listEndereco;
    }
}
