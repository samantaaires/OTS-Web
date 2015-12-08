package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ArtistaDAO;
import com.model.Artista;

@Stateless
public class ArtistaFacadeImp implements ArtistaFacade{

	@EJB
	private ArtistaDAO artistaDAO;
	
	@Override
	public void save(Artista artista) {
		isArtistaWithAllData(artista);
		artistaDAO.save(artista);
	}

	@Override
	public Artista update(Artista artista) {
		isArtistaWithAllData(artista);
		return artistaDAO.update(artista);
	}
	
	@Override
	public void delete(Artista artista) {
		artistaDAO.delete(artista);
	}

	@Override
	public Artista find(int entityID) {
		return artistaDAO.find(entityID);
	}
	
/*	@Override
	public Artista findByName(String entityName) {
		return artistaDAO.findByName(entityName);
	}*/

	@Override
	public List<Artista> findAll() {
		return artistaDAO.findAll();
	}
	
	private void isArtistaWithAllData(Artista artista){
		boolean hasError = false;
		
		if(artista == null){
			hasError = true;
		}
		
		if (artista.getNomeArtista() == null || "".equals(artista.getNomeArtista().trim())){
			hasError = true;
		}
		
		if(artista.getTelefone() == null || "".equals(artista.getTelefone().trim())){
			hasError = true;
		}
		
//		if(artista.getUser() == null){
//			hasError = true;
//		}
		
		if (hasError){
			throw new IllegalArgumentException("The artista is missing data. Check the name and weight, they should have value.");
		}
	}
}
