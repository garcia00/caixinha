package br.com.cx.caixinha.controller;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.modelo.Transacao;

public class TransacaoFormRequest {

	@NotNull(message = "informe o nome da pessoa")
	private Pessoa pessoa;
	
	@NotNull(message = "Informe valor.")
	private BigDecimal valor;
	@NotNull(message = "Informe mês.")
	private Integer anoMes;
	
	
	
	public Transacao toModel(Pessoa pessoa) {
		
		System.out.println(pessoa.toString());
		return new Transacao(this.valor,this.anoMes,this.pessoa);
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Integer getAnoMes() {
		return anoMes;
	}
	public void setAnoMes(Integer anoMes) {
		this.anoMes = anoMes;
	}
	
	
	
	
	
}
