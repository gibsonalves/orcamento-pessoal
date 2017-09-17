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

import br.com.gibsonalves.orcamento.entidades.Categoria;
import br.com.gibsonalves.orcamento.enumeracoes.TipoMovimento;
import br.com.gibsonalves.orcamento.excecoes.CategoriaInvalidaException;
import br.com.gibsonalves.orcamento.servicos.ServicoCategoria;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	ServicoCategoria servicoCategoria;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listarCategorias(Model model) {
		Iterable<Categoria> categorias = servicoCategoria.listarTodasCategorias();
		model.addAttribute("categorias", categorias);
		model.addAttribute("tipos", TipoMovimento.values());
		return "categoria/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			/*List<ObjectError> erros = bindingResult.getAllErrors();
			for (ObjectError w : erros) {
				System.out.println(w.getDefaultMessage());
			}*/
			throw new CategoriaInvalidaException();
		} else {
			servicoCategoria.salvarCategoria(categoria);
		}

		model.addAttribute("categorias", servicoCategoria.listarTodasCategorias());
		return "categoria/tabela-categorias";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
		try {
			servicoCategoria.apagarCategoria(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public Categoria buscarCategoriaPorId(@PathVariable Long id) {
		Categoria categoria = servicoCategoria.buscarCategoriaPorId(id);
		return categoria;
	}

}
