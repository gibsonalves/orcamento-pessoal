package br.com.gibsonalves.orcamento.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gibsonalves.orcamento.entidades.Periodo;

@Repository
public interface PeriodoRepositorio extends CrudRepository<Periodo, Long> {

}
