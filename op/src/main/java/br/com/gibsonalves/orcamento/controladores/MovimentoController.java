package br.com.gibsonalves.orcamento.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.gibsonalves.orcamento.entidades.Movimento;
import br.com.gibsonalves.orcamento.excecoes.MovimentoInvalidoException;
import br.com.gibsonalves.orcamento.servicos.ServicoMovimento;

@Controller
@RequestMapping("/movimentos")
public class MovimentoController {

	@Autowired
	ServicoMovimento servicoMovimento;

	@RequestMapping(method = RequestMethod.GET)
	public String listarMovimentos(Model model) {
		Iterable<Movimento> movimentos = servicoMovimento.listarTodosMovimentos();
		model.addAttribute("movimentos", movimentos);
		return "movimento/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarMovimento(@Valid @ModelAttribute Movimento movimento, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			throw new MovimentoInvalidoException();
		} else {
			servicoMovimento.salvarMovimento(movimento);
		}

		model.addAttribute("movimentos", servicoMovimento.listarTodosMovimentos());
		return "movimento/tabela-movimentos";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletarMovimento(@PathVariable Long id) {
		try {
			servicoMovimento.apagarMovimento(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Movimento buscarMovimentoPorId(@PathVariable Long id) {
		Movimento movimento = servicoMovimento.buscarMovimentoPorId(id);
		return movimento;
	}

}
