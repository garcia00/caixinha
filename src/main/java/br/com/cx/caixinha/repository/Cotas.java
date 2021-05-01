package br.com.cx.caixinha.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import br.com.cx.caixinha.modelo.Cota;

public interface Cotas  extends JpaRepository<Cota, Long>{
	

}
