package com.example.algamoney.api.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Endereco {

	@Size(min = 0, max = 30)
	private String logradouro;

	@Size(min = 0, max = 5)
	private String numero;

	@Size(min = 0, max = 30)
	private String complemento;

	@Size(min = 0, max = 20)
	private String bairro;

	@Size(min = 0, max = 10)
	private String cep;

	@Size(min = 0, max = 20)
	private String cidade;

	@Size(min = 0, max = 20)
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

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + "]";
	}

}
