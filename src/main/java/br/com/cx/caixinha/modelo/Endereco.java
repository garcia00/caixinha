package br.com.cx.caixinha.modelo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	@Column(name = "NUMERO", nullable = false, precision = 2)
	private String numero;

	@Column(name = "RUA", nullable = false, length = 255)
	private String rua;
	
	@Column(name = "CIDADE", nullable = false, length = 63)
	private String cidade;
	
	@Column(name = "BAIRRO", nullable = false, length = 63)
	private String bairro;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
