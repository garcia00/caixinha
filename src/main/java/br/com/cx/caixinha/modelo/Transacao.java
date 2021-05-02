package br.com.cx.caixinha.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.cx.caixinha.dominio.TipoTransacao;


@Entity
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	private TipoTransacao tipoTransacao;
	private Date data;	
	private BigDecimal valor;
	private Integer anoMes;
	
	@ManyToOne
	private Pessoa pessoa;
	
	
	
	
	public Transacao(BigDecimal valor, Integer anoMes, Pessoa pessoa) {		
		this.valor = valor;
		this.anoMes = anoMes;
		this.pessoa = pessoa;
	}

	public Transacao aplicarDeposito() {
		setTipoTransacao(TipoTransacao.DEPOSITO);
		return this;
		
	}
	
	public Transacao aplicarEmprestimo() {
		setTipoTransacao(TipoTransacao.EMPRESTIMO);
		return this;
		
	}
	public Boolean emprestimo() {
		return getTipoTransacao().getDescricao().equals(TipoTransacao.EMPRESTIMO.getDescricao());
	}
	
	public Boolean deposito() {
		return getTipoTransacao().getDescricao().equals(TipoTransacao.DEPOSITO.getDescricao());
	}

	public Long getId() {
		return id;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public Date getData() {
		return data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getAnoMes() {
		return anoMes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	
	
	

}
