package br.com.builder;

import java.math.BigDecimal;
import java.util.Date;

import br.com.model.Funcionario;
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

	public VendaBuilder vendaComDataDeCompra(Date dataDaVenda) {
		venda.setDataDaVenda(dataDaVenda);
		return this;
	}

	public VendaBuilder vendaComVendedor(Funcionario funcionario) {
		venda.setFuncionario(funcionario);
		return this;
	}

	public VendaBuilder vendaComValor(BigDecimal salario) {
		venda.setValorDaVenda(salario.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}

	public Venda getNovoVenda() {
		return venda;
	}

}
