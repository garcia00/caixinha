package br.com.cx.caixinha.dominio;

public enum TipoTransacao {
 
	DEPOSITO("Deposito"), 
	EMPRESTIMO("Emprestimo");

	private String descricao;

	TipoTransacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
