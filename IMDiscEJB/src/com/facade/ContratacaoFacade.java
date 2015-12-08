package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Contratacao;

@Local
public interface ContratacaoFacade {
	public abstract void save(Contratacao contratacao);

	public abstract Contratacao update(Contratacao contratacao);
	
	public abstract void delete(Contratacao contratacao);

	public abstract Contratacao find(int entityID);

	//public abstract Contratacao findByName(String entityName);

	public abstract List<Contratacao> findAll(); 
	
}
