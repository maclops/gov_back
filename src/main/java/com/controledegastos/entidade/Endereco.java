package com.controledegastos.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Size(max = 50, message = "Logradouro")
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "numero")
	private String numero;

	@Size(max = 50, message = "Complemento")
	@Column(name = "complemento")
	private String complemento;

	@Size(max = 30, message = "Bairro")
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cep")
	private String cep;
	
	@Size(max = 50, message = "Cidade")
	@Column(name = "cidade")
	private String cidade;
	
	@Size(max = 30, message = "Estado")
	@Column(name = "estado")
	private String estado;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
