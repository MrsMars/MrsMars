package com.aoher.facade;

import com.aoher.dao.EnderecoDao;
import com.aoher.model.Endereco;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Stateless
public class EnderecoFacade implements Serializable {

    private static final long serialVersionUID = 1627056446345539056L;

    @Inject
    private EnderecoDao enderecoDao;

    public Endereco insert(Endereco endereco) {
        return enderecoDao.insert(endereco);
    }

    public Endereco update(Endereco endereco) {
        return enderecoDao.update(endereco);
    }

    public boolean delete(Endereco endereco) {
        return enderecoDao.delete(endereco);
    }

    public List<Endereco> findAll() {
        return enderecoDao.findAll();
    }
}
