package com.facade;

import java.util.List;

import javax.ejb.Local;

import com.model.Artista;

@Local
public interface ArtistaFacade {
	public abstract void save(Artista Artista);

	public abstract Artista update(Artista Artista);
	
	public abstract void delete(Artista Artista);

	public abstract Artista find(int entityID);

	//public abstract Artista findByName(String entityName);

	public abstract List<Artista> findAll(); 
	
}