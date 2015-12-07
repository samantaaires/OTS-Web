package com.mb;

import java.io.Serializable;
//import java.util.List;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.facade.ArtistaFacade;
import com.model.Artista;

@ManagedBean(name = "artistaMB")
@SessionScoped
public class ArtistaMB implements Serializable {
	private static final long serialVersionUID = -329216827348989761L;

	private Artista artista;
	
	@EJB
	private ArtistaFacade artistaFacade;
	
	private static final String CREATE_ARTISTA = "createArtista";
	private static final String DELETE_ARTISTA = "deleteArtista"; 
	private static final String UPDATE_ARTISTA = "updateArtista";
	private static final String LIST_ALL_ARTISTAS = "listAllArtistas";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	public Artista getArtista() {
		
		if(artista == null){
			artista = new Artista();
		}
		
		return artista;
	}
	
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	public List<Artista> getAllArtistas() {
		return artistaFacade.findAll();
	}
	
	public String updateArtistaStart(){
		return UPDATE_ARTISTA;
	}
	
	public String updateArtistaEnd(){
		try {
			artistaFacade.update(artista);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the Telefone is above 0 or call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_ARTISTAS;
	}
	
	public String deleteArtistaStart(){
		return DELETE_ARTISTA;
	}
	
	public String deleteArtistaEnd(){
		try {
			artistaFacade.delete(artista);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_ARTISTAS;
	}
	
	public String createArtistaStart(){
		return CREATE_ARTISTA;
	}
		
	public String createArtistaEnd(){
		try {
			artistaFacade.save(artista);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the telefone is above 0 or call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_ARTISTAS;
	}
	
	public String listAllArtistas(){
		return LIST_ALL_ARTISTAS;
	}
	
	private void sendInfoMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	private void sendErrorMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
		
	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}
	
}
