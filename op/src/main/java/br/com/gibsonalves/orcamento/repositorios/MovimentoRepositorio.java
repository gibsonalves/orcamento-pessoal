package br.com.gibsonalves.orcamento.repositorios;

import java.util.Calendar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gibsonalves.orcamento.entidades.Movimento;

@Repository
public interface MovimentoRepositorio extends CrudRepository<Movimento, Long> {

	@Query("SELECT sum(m.valor) FROM Movimento m WHERE m.categoria.id = ? and m.data between ? and ?")
	public Double sumByCategoriaByPeriodo(Long idCategoria, Calendar inicio, Calendar termino);
	
}
