package com.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.dao.EstabelecimentoDAO;
import com.model.Estabelecimento;

@Stateless
public class EstabelecimentoFacadeImp implements EstabelecimentoFacade{

	@EJB
	private EstabelecimentoDAO estabelecimentoDAO;
	
	@Override
	public void save(Estabelecimento estabelecimento) {
		isEstabelecimentoWithAllData(estabelecimento);
		estabelecimentoDAO.save(estabelecimento);
	}

	@Override
	public Estabelecimento update(Estabelecimento estabelecimento) {
		isEstabelecimentoWithAllData(estabelecimento);
		return estabelecimentoDAO.update(estabelecimento);
	}
	
	@Override
	public void delete(Estabelecimento estabelecimento) {
		estabelecimentoDAO.delete(estabelecimento);
	}

	@Override
	public Estabelecimento find(int entityID) {
		return estabelecimentoDAO.find(entityID);
	}
	
/*	@Override
	public Artista findByName(String entityName) {
		return artistaDAO.findByName(entityName);
	}*/

	@Override
	public List<Estabelecimento> findAll() {
		return estabelecimentoDAO.findAll();
	}
	
	private void isEstabelecimentoWithAllData(Estabelecimento estabelecimento){
		boolean hasError = false;
		
		if(estabelecimento == null){
			hasError = true;
		}
		
		if (estabelecimento.getNomeEstabelecimento() == null || "".equals(estabelecimento.getNomeEstabelecimento().trim())){
			hasError = true;
		}
		
		if(estabelecimento.getTelefone() == null || "".equals(estabelecimento.getTelefone().trim())){
			hasError = true;
		}
		
//		if(artista.getUser() == null){
//			hasError = true;
//		}
		
		if (hasError){
			throw new IllegalArgumentException("The estabelecimento is missing data. Check the name and weight, they should have value.");
		}
	}
}