package br.com.cx.caixinha.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.modelo.Transacao;
import br.com.cx.caixinha.repository.Pessoas;
import br.com.cx.caixinha.repository.Transacoes;
import br.com.cx.caixinha.service.DepositoService;

@Controller
@RequestMapping("/deposito")
public class ControllerDeposito {

	@Autowired
	private Pessoas pessoas;

	@Autowired
	private Transacoes transacoes;


	@Autowired
	private DepositoService depositoService;

	private static final String PAGAMENTO_DEPOSITO = "pagamentoDeposito";
	private static final String PESQUISAR_COTISTA = "pesquisarCotista";


	@GetMapping("{id}")
	public ModelAndView novo(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mv = new ModelAndView(PAGAMENTO_DEPOSITO);

    Optional<Pessoa> pessoa = this.pessoas.findById(id);

    if(pessoa.isPresent()) {
    	TransacaoFormRequest transacaoFormRequest = new TransacaoFormRequest();
    	transacaoFormRequest.setPessoa(pessoa.get());
    	transacaoFormRequest.setAnoMes(Integer.valueOf(new SimpleDateFormat("MMYYYY").format(new Date())));
    	mv.addObject("transacaoFormRequest",transacaoFormRequest);

    }else {
    	mv.addObject("transacaoFormRequest", new TransacaoFormRequest());

    }


      return mv;
	}


	@PostMapping("/salvar")
	@Transactional
	public ModelAndView depositar(TransacaoFormRequest requestTransacao, HttpSession session) {


		ModelAndView mv = new ModelAndView(PESQUISAR_COTISTA);


		requestTransacao.toModel();

		transacoes.save(requestTransacao.toModel().aplicarDeposito());


		return mv;
	}



}
