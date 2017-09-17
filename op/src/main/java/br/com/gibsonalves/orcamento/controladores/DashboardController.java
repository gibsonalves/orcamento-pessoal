package br.com.gibsonalves.orcamento.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gibsonalves.orcamento.entidades.Categoria;
import br.com.gibsonalves.orcamento.entidades.Periodo;
import br.com.gibsonalves.orcamento.servicos.ServicoCategoria;
import br.com.gibsonalves.orcamento.servicos.ServicoPeriodo;
import br.com.gibsonalves.orcamento.util.Util;

@Controller
@RequestMapping("/dash")
public class DashboardController {

	@Autowired
	private ServicoPeriodo servicoPeriodo;
	@Autowired
	private ServicoCategoria servicoCategoria;

	@RequestMapping(method = RequestMethod.GET)
	public String listaDadosDashBoard(Model model) {
		String html;
		html = "<table class=\"table table-hover table-condensed table-striped table-bordered\">\n";
		html += "<thead>\n";
		html += "<tr>\n";
		html += "<td>2017</td>"; ////////BUSCAR ANO

		//Header
		Iterable<Periodo> iPeriodos = servicoPeriodo.listarTodosPeriodos();
		List<Periodo> periodos = Util.toList(iPeriodos);
		for (Periodo p : periodos) {
			html += "<td class=\"topTable\">" + p.getNome() + "</td>";
		}
		html += "</tr>\n";
		html += "</thead>\n";
		//
		
		//Content
		Iterable<Categoria> iCategorias = servicoCategoria.listarTodasCategorias();
		List<Categoria> categorias = Util.toList(iCategorias);
		for (Categoria c : categorias) {
			html += "<tr>\n";
			html += "<td class=\"itemCategoria\">" + c.getNome() + "</td>\n";
			for (Periodo p : periodos) {
				html += "<td class=\"itemLista\">" + 0 + "</td>";
			}
			html += "</tr>\n";
		}
		//
		
		html += "</table>\n";
		model.addAttribute("html", html);
		return "dash/dash";
	}

}