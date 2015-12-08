package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Estabelecimento;

@Local
public interface EstabelecimentoFacade {
	public abstract void save(Estabelecimento estabelecimento);

	public abstract Estabelecimento update(Estabelecimento estabelecimento);
	
	public abstract void delete(Estabelecimento estabelecimento);

	public abstract Estabelecimento find(int entityID);

	//public abstract Artista findByName(String entityName);

	public abstract List<Estabelecimento> findAll(); 
	
}
