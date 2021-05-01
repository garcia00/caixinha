package br.com.cx.caixinha.errorMessagem;

public class  MovimentacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MovimentacaoException(String message) {
		super(message);
	}

}
