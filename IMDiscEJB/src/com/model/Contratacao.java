package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQ_CONTRATACAO", initialValue=1, allocationSize=1, sequenceName="seq_contratacao")
public class Contratacao implements Serializable {
	private static final long serialVersionUID = -3379758744266283863L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_CONTRATACAO")
    private int idContratacao;
	
	@ManyToOne
    @JoinColumn(name="idArtista")
    private Artista artista;
	
	@ManyToOne
    @JoinColumn(name="idEstabelecimento")
    private Estabelecimento estabelecimento;
	
	@Column
	private boolean aceito = false;
	
	public int getIdContratacao() {
		return idContratacao;
	}

	public void setIdContratacao(int idContratacao) {
		this.idContratacao = idContratacao;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public boolean isAceito() {
		return aceito;
	}

	public void setAceito(boolean aceito) {
		this.aceito = aceito;
	}
}