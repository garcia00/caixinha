package br.com.cx.caixinha.controller;

import br.com.cx.caixinha.modelo.Pessoa;
import br.com.cx.caixinha.repository.Pessoas;
import br.com.cx.caixinha.repository.Transacoes;
import br.com.cx.caixinha.service.DepositoService;
import br.com.cx.caixinha.service.EmprestimoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/emprestimo")
@SessionAttributes(value = "transacaoFormRequest")
public class ControllerEmprestimo {

	@Autowired
	private Pessoas pessoas;

	@Autowired
	private Transacoes transacoes;

	@Autowired
	private EmprestimoService emprestimoService;

	private static final String EMPRESTIMO = "emprestimo";
	private static final String PESQUISAR_COTISTA = "pesquisarCotista";


	@GetMapping("{id}")
	public ModelAndView novo(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mv = new ModelAndView(EMPRESTIMO);

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
	public ModelAndView emprestar(@Valid @ModelAttribute("transacaoFormRequest") TransacaoFormRequest requestTransacao , BindingResult result) {
		ModelAndView mv = null;
			if(result.hasErrors()){
				mv =new ModelAndView(EMPRESTIMO);
			}else {
				transacoes.save(requestTransacao.toModel().aplicarEmprestimo());

				mv =  new ModelAndView("redirect:/pessoas");

			}

		return mv;

	}



}
