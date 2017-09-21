package br.com.gibsonalves.orcamento.servicos;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gibsonalves.orcamento.entidades.Movimento;
import br.com.gibsonalves.orcamento.repositorios.MovimentoRepositorio;

@Service
public class ServicoMovimento {

	@Autowired
	MovimentoRepositorio movimentoRepositorio;
	@Autowired
	ServicoAutenticacao servicoAutenticacao;

	public Iterable<Movimento> listarTodosMovimentos() {
		return movimentoRepositorio.findAll();
	}

	public void salvarMovimento(Movimento movimento) {
		movimento.setUsuario(servicoAutenticacao.getUsuarioLogado());
		movimentoRepositorio.save(movimento);
	}

	public void apagarMovimento(Long id) {
		movimentoRepositorio.delete(id);
	}

	public Movimento buscarMovimentoPorId(Long id) {
		return movimentoRepositorio.findOne(id);
	}
	
	public Double somaMovimentosPorPeriodoECategoria(Long idCategoria, Calendar inicio, Calendar termino) {
		Double r;
		r = movimentoRepositorio.sumByCategoriaByPeriodo(idCategoria, inicio, termino);
		return r;
	}
	

}
