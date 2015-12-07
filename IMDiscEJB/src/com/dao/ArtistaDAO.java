package com.dao;

import javax.ejb.Stateless;

import com.model.Artista;

@Stateless
public class ArtistaDAO extends GenericDAO<Artista> {

	public ArtistaDAO() {
		super(Artista.class);
	    }
	    
	    public void delete(Artista artista) {
	        super.delete(artista.getIdArtista(), Artista.class);
	    }

}
