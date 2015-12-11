package com.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQ_ARTISTA", initialValue=1, allocationSize=1, sequenceName="seq_artista")
public class Artista implements Serializable {
	private static final long serialVersionUID = -3379758744266283863L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ARTISTA")
    private int idArtista;
	
	@Column(nullable=false)
	private String nomeArtista;
	private String telefone;
	
	//private String login; --substituido login e senha por user
	//private String senha;
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_user")
//	private User user;
	
	/*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_escolha")	
	private Escolha escolha;
	
	@ManyToOne 
	@JoinColumn(name="id_estruturaCurricular")
	private EstruturaCurricular estruturaCurricular; */
	
	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista= idArtista;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista= nomeArtista;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone= telefone;
	}

	/* public Escolha getEscolha() {
		return escolha;
	}
	public void setEscolha(Escolha escolha) {
		this.escolha = escolha;
	}
	public EstruturaCurricular getEstruturaCurricular() {
		return estruturaCurricular;
	}
	public void setEstruturaCurricular(EstruturaCurricular estruturaCurricular) {
		this.estruturaCurricular = estruturaCurricular;
	} */

//	
//	public User getUser() {
//		return user;
//	}
//
//	
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
}