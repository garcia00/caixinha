package br.com.cx.caixinha.errorMessagem;

public class CotaNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;

	public CotaNotFoundException(Long id) {
		super("Não foi possivel encontrar a conta: " + id);
	}

	public CotaNotFoundException() {
		super("Não foi possivel encontrar a conta");
	}

}
