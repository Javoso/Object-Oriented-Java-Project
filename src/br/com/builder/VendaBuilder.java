package br.com.builder;

import java.math.BigDecimal;
import java.util.Date;

import br.com.model.Venda;

/**
 * 
 * Classe VendaBuilder � utilizado para a cri��o de um ou v�rios objetos com
 * muitas op��es poss�veis de inicializa��o.
 * 
 * @author O Javoso
 *
 */

public class VendaBuilder {

	private Venda venda;

	public VendaBuilder() {
		venda = new Venda();
	}

	/**
	 * 
	 * Adiciona a data que a venda foi realizada e retorna o objeto da classe
	 * VendaBuilder
	 * 
	 * @param dataDaVenda
	 * @return
	 */
	public VendaBuilder vendaComDataDeCompra(Date dataDaVenda) {
		venda.setDataDaVenda(dataDaVenda);
		return this;
	}

	/**
	 * 
	 * Adiciona o valor da compra e retorna o objeto da classe VendaBuilder
	 * 
	 * @param valorDaCompra
	 * @return
	 */

	public VendaBuilder vendaComValor(BigDecimal valorDaCompra) {
		venda.setValorDaVenda(valorDaCompra.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}

	/**
	 * Retorna o objeto criado da classe Venda com os valor que foram setados nele.
	 * 
	 * @return
	 */
	public Venda getNovoVenda() {
		return venda;
	}

}
