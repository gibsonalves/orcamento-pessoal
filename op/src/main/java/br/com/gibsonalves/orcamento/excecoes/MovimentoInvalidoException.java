package br.com.gibsonalves.orcamento.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MovimentoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = -7437994210056347851L;

}
