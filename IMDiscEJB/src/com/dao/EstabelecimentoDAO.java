package com.dao;

import javax.ejb.Stateless;

import com.model.Estabelecimento;

@Stateless
public class EstabelecimentoDAO extends GenericDAO<Estabelecimento> {

	public EstabelecimentoDAO() {
		super(Estabelecimento.class);
	    }
	    
	    public void delete(Estabelecimento estabelecimento) {
	        super.delete(estabelecimento.getIdEstabelecimento(), Estabelecimento.class);
	    }

}
