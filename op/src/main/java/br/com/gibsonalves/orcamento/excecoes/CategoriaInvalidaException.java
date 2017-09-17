package br.com.gibsonalves.orcamento.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CategoriaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 736813261245921759L;

}
