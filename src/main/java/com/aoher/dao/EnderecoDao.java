package com.aoher.dao;

import com.aoher.dao.abstracts.AbstractDao;
import com.aoher.model.Endereco;

import javax.ejb.Stateless;

@Stateless
public class EnderecoDao extends AbstractDao<Endereco> {

    public EnderecoDao() {
        super(Endereco.class);
    }
}
