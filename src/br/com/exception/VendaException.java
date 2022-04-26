package br.com.exception;

import java.io.Serializable;

/**
 * 
 * Classe para ser utilizada na lançamento de excessões relacionadas a classe model Cargo.
 * 
 * @author O Javoso
 *
 */

public class VendaException extends RuntimeException implements Serializable  {

	private static final long serialVersionUID = -1488996630774909620L;
	
	/**
	 * 
	 * Construtor padrão para realizar o lançamento da exception com a informação
	 * passada por parâmetro.
	 * 
	 * @param exception
	 */
	
	public VendaException(String exception) {
		super(exception);
	}
	
	
}
