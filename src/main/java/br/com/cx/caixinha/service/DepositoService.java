package br.com.cx.caixinha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.repository.Pessoas;

@Service
public class DepositoService {
	
	@Autowired
	private Pessoas pessoas;
	
	public String receber(Long id) {
		Pessoa pessoa = pessoas.getOne(id);
		pessoas.save(pessoa);
		
		return "Pago!";
	}

}
