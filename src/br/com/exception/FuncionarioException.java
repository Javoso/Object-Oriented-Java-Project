package br.com.exception;

import java.io.Serializable;

/**
 * 
 * Classe para ser utilizada na lan�amento de excess�es relacionadas a classe
 * model Funcionario
 * 
 * @author O Javoso
 *
 */

public class FuncionarioException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 3979863341390212526L;

	/**
	 * 
	 * Construtor padr�o para realizar o lan�amento da exception com a informa��o
	 * passada por par�metro.
	 * 
	 * @param exception
	 */
	public FuncionarioException(String exception) {
		super(exception);

	}

}
