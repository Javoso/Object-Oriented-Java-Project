package br.com.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * Classe model Venda com seu atributos e metódos.
 * 
 * @author O Javoso
 *
 */
public class Venda {

	private BigDecimal valorDaVenda;
	private Date dataDaVenda;

	public Venda() {
	}

	/**
	 * 
	 * Construtor com paramentros para inicializar o objeto.
	 * 
	 * @param nomeDoFuncionario
	 * @param valorDaVenda
	 * @param dataDaVenda
	 */
	public Venda(BigDecimal valorDaVenda, Date dataDaVenda) {
		super();
		this.valorDaVenda = valorDaVenda;
		this.dataDaVenda = dataDaVenda;
	}

	public BigDecimal getCargoDoFuncionario() {
		return valorDaVenda;
	}

	public void setCargoDoFuncionario(BigDecimal valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}

	public Date getDataDaContratacao() {
		return dataDaVenda;
	}

	public void setDataDaContratacao(Date dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valorDaVenda == null) ? 0 : valorDaVenda.hashCode());
		result = prime * result + ((dataDaVenda == null) ? 0 : dataDaVenda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (valorDaVenda == null) {
			if (other.valorDaVenda != null)
				return false;
		} else if (!valorDaVenda.equals(other.valorDaVenda))
			return false;
		if (dataDaVenda == null) {
			if (other.dataDaVenda != null)
				return false;
		} else if (!dataDaVenda.equals(other.dataDaVenda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " Venda { \n Data da Venda: " + dataDaVenda + ",\n Dados do Cargo do Funcionario : " + valorDaVenda
				+ "\n }";
	}

}
