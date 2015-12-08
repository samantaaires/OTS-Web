package com.dao;

import javax.ejb.Stateless;

import com.model.Contratacao;

@Stateless
public class ContratacaoDAO extends GenericDAO<Contratacao> {

	public ContratacaoDAO() {
		super(Contratacao.class);
	    }
	    
	    public void delete(Contratacao contratacao) {
	        super.delete(contratacao.getIdContratacao(), Contratacao.class);
	    }

}
