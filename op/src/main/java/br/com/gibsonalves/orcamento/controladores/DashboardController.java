package br.com.gibsonalves.orcamento.controladores;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gibsonalves.orcamento.entidades.Categoria;
import br.com.gibsonalves.orcamento.entidades.Periodo;
import br.com.gibsonalves.orcamento.servicos.ServicoCategoria;
import br.com.gibsonalves.orcamento.servicos.ServicoMovimento;
import br.com.gibsonalves.orcamento.servicos.ServicoOrcamento;
import br.com.gibsonalves.orcamento.servicos.ServicoPeriodo;
import br.com.gibsonalves.orcamento.util.Util;

@Controller
@RequestMapping("/dash")
public class DashboardController {

		@Autowired
	private ServicoCategoria servicoCategoria;
	@Autowired
	private ServicoMovimento servicoMovimento;
	@Autowired
	private ServicoOrcamento servicoOrcamento;
	@Autowired
	private ServicoPeriodo servicoPeriodo;

	@RequestMapping(method = RequestMethod.GET)
	public String listaDadosDashBoard(Model model) {
		String html;
		html = "<fmt:setLocale value = \"pt_BR\"/>\r\n"; 
		html += "<table class=\"table table-hover table-condensed table-striped table-bordered\">\n";
		html += "<thead>\n";
		html += "<tr>\n";
		html += "<td>2017</td>"; //////// BUSCAR ANO

		// Header
		Iterable<Periodo> iPeriodos = servicoPeriodo.listarTodosPeriodos();
		List<Periodo> periodos = Util.toList(iPeriodos);
		for (Periodo p : periodos) {
			html += "<td class=\"topTable\">" + p.getNome() + "</td>";
		}
		html += "</tr>\n";
		html += "</thead>\n";
		//

		Locale ptBr = new Locale("pt", "BR");
		//NumberFormat formato = NumberFormat.getCurrencyInstance(ptBr);
		NumberFormat formato = NumberFormat.getNumberInstance(ptBr);
		formato.setMinimumFractionDigits(2);
		formato.setMaximumFractionDigits(2);
		
		
		// Content
		Iterable<Categoria> iCategorias = servicoCategoria.listarTodasCategorias();
		List<Categoria> categorias = Util.toList(iCategorias);
		for (Categoria c : categorias) {
			html += "<tr>\n";
			html += "<td class=\"itemCategoria\">" + c.getNome() + "</td>\n";
			for (Periodo p : periodos) {
				Double valorMovimento = servicoMovimento.somaMovimentosPorPeriodoECategoria(c.getId(), p.getInicio(),p.getTermino());
				if (valorMovimento == null)
					valorMovimento = (double) 0;
				Double valorOrcamento = servicoOrcamento.somaOrcamentoPorIdPeriodoEIdCategoria(p.getId(), c.getId());
				if (valorOrcamento == null)
					valorOrcamento = (double) 0;
				String classCelula;
				if (valorMovimento > valorOrcamento) {
					classCelula = "celulaVermelha";
				} else if (valorMovimento > 0 && valorMovimento < valorOrcamento) {
					classCelula = "celulaAmarela";
				} else if (valorMovimento > 0 && valorMovimento.equals(valorOrcamento)) {
					classCelula = "celulaVerde";
				} else if (valorOrcamento > 0) {
					classCelula = "celulaAzul";
				} else {
					classCelula = "celulaComum";
				}
				html += "<td class=\"itemLista " + classCelula + "\" data-idPeriodo=\"" + p.getId() +
						"\" data-idCategoria=\"" + c.getId() + "\">" +
						"<a href=\"#\" data-toggle=\"tooltip\" title=\"" + c.getNome() +
						"\nGastos: " + formato.format(valorMovimento) +
						"\nOrçamento: " + formato.format(valorOrcamento) + 
						"\nSaldo: " + formato.format((valorOrcamento - valorMovimento)) +
						"\">" +
						formato.format(Math.max(valorOrcamento, valorMovimento)) +
						"</a></td>";
			}
			html += "</tr>\n";
		}
		//

		html += "</table>\n";
		model.addAttribute("html", html);
		return "dash/dash";
	}

}