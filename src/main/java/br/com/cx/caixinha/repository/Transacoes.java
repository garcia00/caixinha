package br.com.cx.caixinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cx.caixinha.modelo.Pessoa;

public interface Transacoes  extends JpaRepository<Pessoa, Long>{

}
