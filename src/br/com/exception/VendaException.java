package br.com.exception;

import java.io.Serializable;

/**
 * 
 * Classe para ser utilizada na lan�amento de excess�es relacionadas a classe model Cargo.
 * 
 * @author O Javoso
 *
 */

public class VendaException extends RuntimeException implements Serializable  {

	private static final long serialVersionUID = -1488996630774909620L;
	
	/**
	 * 
	 * Construtor padr�o para realizar o lan�amento da exception com a informa��o
	 * passada por par�metro.
	 * 
	 * @param exception
	 */
	
	public VendaException(String exception) {
		super(exception);
	}
	
	
}
