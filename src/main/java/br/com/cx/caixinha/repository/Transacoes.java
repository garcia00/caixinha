package br.com.cx.caixinha.repository;

import br.com.cx.caixinha.modelo.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Transacoes  extends JpaRepository<Transacao, Long>{

}
