package com.aoher.mb;

import com.aoher.facade.PessoaFacade;
import com.aoher.mb.abstracts.AbstractMB;
import com.aoher.model.Pessoa;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaMB extends AbstractMB<Pessoa> implements Serializable {

    private static final long serialVersionUID = -305017905383380165L;

    @Inject
    private PessoaFacade pessoaFacade;

    private List<Pessoa> listPessoa;

    @Override
    @PostConstruct
    protected void init() {
        novaPessoa();
        carregarPessoas();
    }

    public void salvar() {
        if (getSelectedBean().getId() == null) {
            adicionarPessoa(pessoaFacade.insert(getSelectedBean()));
        } else {
            removerPessoa(getSelectedBean());
            adicionarPessoa(pessoaFacade.update(getSelectedBean()));
        }
    }

    public void deletar() {
        removerPessoa(getSelectedBean());
        pessoaFacade.delete(getSelectedBean());
        novaPessoa();
    }

    public void cancelar() {
        novaPessoa();
    }

    private void novaPessoa() {
        setSelectedBean(new Pessoa());
    }

    private void adicionarPessoa(Pessoa pessoa) {
        listPessoa.add(pessoa);
    }

    private void removerPessoa(Pessoa p) {
        listPessoa.remove(p);
    }

    private void carregarPessoas() {
        listPessoa = pessoaFacade.findAll();
    }

    public List<Pessoa> getListPessoa() {
        return listPessoa;
    }
}
