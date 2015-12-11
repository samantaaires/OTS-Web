package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQ_ESTABELECIMENTO", initialValue=1, allocationSize=1, sequenceName="seq_estabelecimento")
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = -329216827348989761L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ESTABELECIMENTO")
    private int idEstabelecimento;
	
	@Column(nullable=false)
	private String nomeEstabelecimento;
	private String telefone;
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}
	public void setIdEstabelecimento(int idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}
	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}
	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}