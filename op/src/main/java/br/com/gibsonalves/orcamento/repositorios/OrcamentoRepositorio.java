package br.com.gibsonalves.orcamento.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gibsonalves.orcamento.entidades.Orcamento;

@Repository
public interface OrcamentoRepositorio extends CrudRepository<Orcamento, Long>{

	@Query("SELECT sum(o.valor) FROM Orcamento o WHERE o.periodo.id = ? and o.categoria.id = ?")
	public Double sumByIdPeriodoAndByIdCategoria(Long idPeriodo, Long idCategoria);
	
}
