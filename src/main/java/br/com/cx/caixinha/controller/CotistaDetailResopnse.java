package br.com.cx.caixinha.controller;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.modelo.Transacao;

import java.math.BigDecimal;
import java.util.Optional;

public class CotistaDetailResopnse {


    private String nome;

    private String contato;

    private BigDecimal saldo;

    private Long id;

    public CotistaDetailResopnse(Pessoa pessoa) {

        this.id = pessoa.getId();


        this.nome = pessoa.getNome();

        this.contato = pessoa.getContato().getDddCelular();


        saldo = calcularSaldo(pessoa);

    }

    private BigDecimal calcularSaldo(Pessoa pessoa)  {

         BigDecimal totalDeposito = pessoa
                 .getTransacoes()
                 .stream()
                 .filter(tr1->tr1.deposito())
                 .map(Transacao::getValor)
                 .reduce(BigDecimal::add)
                 .orElse(new BigDecimal("0"));

         BigDecimal totalEmprestimo = pessoa
                 .getTransacoes()
                 .stream()
                 .filter(tr1->tr1.emprestimo())
                 .map(Transacao::getValor)
                 .reduce(BigDecimal::add)
                 .orElse(new BigDecimal("0"));

        return totalDeposito.subtract(totalEmprestimo);
    }


    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Long getId() {
        return id;
    }
}
