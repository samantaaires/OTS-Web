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

import com.facade.EstabelecimentoFacade;
import com.facade.ArtistaFacade;
import com.facade.ContratacaoFacade;
import com.model.Artista;
import com.model.Contratacao;
import com.model.Estabelecimento;

@ManagedBean(name = "estabelecimentoMB")
@SessionScoped
public class EstabelecimentoMB implements Serializable {
	private static final long serialVersionUID = -329216827348989761L;

	private Estabelecimento estabelecimento;
	
	private Artista artista;
	
	@EJB
	private EstabelecimentoFacade estabelecimentoFacade;
	private ArtistaFacade artistaFacade;
	private ContratacaoFacade contratacaoFacade;
	
	private static final String CREATE_ESTABELECIMENTO = "createEstabelecimento";
	private static final String DELETE_ESTABELECIMENTO = "deleteEstabelecimento"; 
	private static final String UPDATE_ESTABELECIMENTO = "updateEstabelecimento";
	private static final String LIST_ALL_ESTABELECIMENTOS = "listAllEstabelecimentos";
	private static final String FIND_ESTABELECIMENTO = "findEstabelecimento";
	private static final String LIST_FOUND_ESTABELECIMENTOS = "listFoundEstabelecimentos";
	private static final String CONTRATAR_ARTISTA  = "contratarArtista";
	private static final String ESTABELECIMENTO_LIST_ALL_ARTISTAS = "estabelecimento_listAllArtistas";
	private static final String STAY_IN_THE_SAME_PAGE = null;

	public Estabelecimento getEstabelecimento() {
		
		if(estabelecimento == null){
			estabelecimento = new Estabelecimento();
		}
		
		return estabelecimento;
	}
	
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
public Artista getArtista() {
		
		if(artista == null){
			artista = new Artista();
		}
		
		return artista;
	}
	
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	public List<Estabelecimento> getAllEstabelecimentos() {
		return estabelecimentoFacade.findAll();
	}
	

	
	public String updateEstabelecimentoStart(){
		return UPDATE_ESTABELECIMENTO;
	}
	
	public String updateEstabelecimentoEnd(){
		try {
			estabelecimentoFacade.update(estabelecimento);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the Telefone is above 0 or call the adm");
			return STAY_IN_THE_SAME_PAGE;
		}
		
		sendInfoMessageToUser("Operation Complete: Update");
		return LIST_ALL_ESTABELECIMENTOS;
	}
	
	public String deleteEstabelecimentoStart(){
		return DELETE_ESTABELECIMENTO;
	}
	
	public String deleteEstabelecimentoEnd(){
		try {
			estabelecimentoFacade.delete(estabelecimento);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Call the ADM");
			return STAY_IN_THE_SAME_PAGE;
		}			
		
		sendInfoMessageToUser("Operation Complete: Delete");
		
		return LIST_ALL_ESTABELECIMENTOS;
	}
	
	public String createEstabelecimentoStart(){
		return CREATE_ESTABELECIMENTO;
	}
		
	public String createEstabelecimentoEnd(){
		try {
			estabelecimentoFacade.save(estabelecimento);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the telefone is above 0 or call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_ESTABELECIMENTOS;
	}
	
	public String listAllEstabelecimentos(){
		try {
			estabelecimentoFacade.save(estabelecimento);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the telefone is above 0 or call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_ALL_ESTABELECIMENTOS;
	}
	
	public String findEstabelecimentoStart() {
		estabelecimentoFacade.findAll().get(0);
		return FIND_ESTABELECIMENTO;
	}
	
	public String findEstabelecimentoEnd(){
		try {
			estabelecimentoFacade.find(estabelecimento.getIdEstabelecimento());
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the telefone is above 0 or call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return LIST_FOUND_ESTABELECIMENTOS;
	}

	public String contratarArtistaStart() {
		return CONTRATAR_ARTISTA;
	}
	
	public String contratarArtistaEnd() {
		Contratacao contratacao = new Contratacao();
		if (estabelecimentoFacade.find(estabelecimento.getIdEstabelecimento())!= null &&
			artistaFacade.find(artista.getIdArtista()) != null) {
		contratacao.setArtista(artista);
		contratacao.setEstabelecimento(estabelecimento);}
		try {
			contratacaoFacade.save(contratacao);
		} catch (EJBException e) {
			sendErrorMessageToUser("Error. Check if the telefone is above 0 or call the adm");
			
			return STAY_IN_THE_SAME_PAGE;
		}		
		
		sendInfoMessageToUser("Operation Complete: Create");
		
		return ESTABELECIMENTO_LIST_ALL_ARTISTAS;
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
