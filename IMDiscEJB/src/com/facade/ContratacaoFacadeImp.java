package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.ContratacaoDAO;
import com.model.Contratacao;

@Stateless
public class ContratacaoFacadeImp implements ContratacaoFacade{

	@EJB
	private ContratacaoDAO contratacaoDAO;
	
	@Override
	public void save(Contratacao contratacao) {
		isContratacaoWithAllData(contratacao);
		contratacaoDAO.save(contratacao);
	}

	@Override
	public Contratacao update(Contratacao contratacao) {
		isContratacaoWithAllData(contratacao);
		return contratacaoDAO.update(contratacao);
	}
	
	@Override
	public void delete(Contratacao contratacao) {
		contratacaoDAO.delete(contratacao);
	}

	@Override
	public Contratacao find(int entityID) {
		return contratacaoDAO.find(entityID);
	}
	
/*	@Override
	public Contratacao findByName(String entityName) {
		return contratacaoDAO.findByName(entityName);
	}*/

	@Override
	public List<Contratacao> findAll() {
		return contratacaoDAO.findAll();
	}
	
	private void isContratacaoWithAllData(Contratacao contratacao){
		boolean hasError = false;
		
		if(contratacao == null){
			hasError = true;
		}
		
		if (contratacao.getArtista() == null){
			hasError = true;
		}
		
		if(contratacao.getEstabelecimento() == null){
			hasError = true;
		}
		
		if(contratacao.isAceito() == true){
			hasError = true;
		}
		
		
//		if(contratacao.getUser() == null){
//			hasError = true;
//		}
		
		if (hasError){
			throw new IllegalArgumentException("The contratacao is missing data. Check the name and weight, they should have value.");
		}
	}
}
