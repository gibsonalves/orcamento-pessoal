package br.com.gibsonalves.orcamento.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gibsonalves.orcamento.entidades.Categoria;
import br.com.gibsonalves.orcamento.repositorios.CategoriaRepositorio;

@Service
public class ServicoCategoria {

	@Autowired
	CategoriaRepositorio categoriaRepositorio;
	@Autowired
	ServicoAutenticacao servicoAutenticacao;

	public Iterable<Categoria> listarTodasCategorias() {
		return categoriaRepositorio.findAll();
	}

	public void salvarCategoria(Categoria categoria) {
		categoria.setUsuario(servicoAutenticacao.getUsuarioLogado());
		categoriaRepositorio.save(categoria);
	}

	public void apagarCategoria(Long id) {
		categoriaRepositorio.delete(id);
	}

	public Categoria buscarCategoriaPorId(Long id) {
		return categoriaRepositorio.findOne(id);
	}

}
