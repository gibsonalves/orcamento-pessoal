package br.com.gibsonalves.orcamento.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.gibsonalves.orcamento.entidades.Movimento;

@Repository
public interface MovimentoRepositorio extends CrudRepository<Movimento, Long> {

}
