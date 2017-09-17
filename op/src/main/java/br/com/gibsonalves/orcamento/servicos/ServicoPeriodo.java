package br.com.gibsonalves.orcamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gibsonalves.orcamento.entidades.Periodo;
import br.com.gibsonalves.orcamento.repositorios.PeriodoRepositorio;

@Service
public class ServicoPeriodo {

	@Autowired
	PeriodoRepositorio periodoRepositorio;
	@Autowired
	ServicoAutenticacao servicoAutenticacao;

	public Iterable<Periodo> listarTodosPeriodos() {
		return periodoRepositorio.findAll();
	}

}
