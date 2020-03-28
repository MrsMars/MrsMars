package com.aoher.dao;

import javax.ejb.Stateless;

import com.aoher.dao.abstracts.AbstractDao;
import com.aoher.model.Pessoa;

@Stateless
public class PessoaDao extends AbstractDao<Pessoa> {

    public PessoaDao() {
        super(Pessoa.class);
    }
}
