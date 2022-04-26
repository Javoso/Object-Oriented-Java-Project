package br.com.exception;

import java.io.Serializable;

/**
 * 
 * Classe para ser utilizada na lançamento de excessões relacionadas a classe
 * model Funcionario
 * 
 * @author O Javoso
 *
 */

public class FuncionarioException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 3979863341390212526L;

	/**
	 * 
	 * Construtor padrão para realizar o lançamento da exception com a informação
	 * passada por parâmetro.
	 * 
	 * @param exception
	 */
	public FuncionarioException(String exception) {
		super(exception);

	}

}
