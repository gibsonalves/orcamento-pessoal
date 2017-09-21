package br.com.gibsonalves.orcamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gibsonalves.orcamento.entidades.Orcamento;
import br.com.gibsonalves.orcamento.repositorios.OrcamentoRepositorio;

@Service
public class ServicoOrcamento {

	@Autowired
	OrcamentoRepositorio orcamentoRepositorio;
	@Autowired
	ServicoAutenticacao servicoAutenticacao;

	public Iterable<Orcamento> listarTodosOrcamentos() {
		return orcamentoRepositorio.findAll();
	}
	
	
	
	public Double somaOrcamentoPorIdPeriodoEIdCategoria(Long idPeriodo, Long idCategoria) {
		Double r;
		r = orcamentoRepositorio.sumByIdPeriodoAndByIdCategoria(idPeriodo, idCategoria);
		return r;
	}

}
