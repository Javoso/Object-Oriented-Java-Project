package br.com.model;

import java.math.BigDecimal;
import java.util.Date;

import br.com.util.DataUtil;

public class Venda {

	private BigDecimal valorDaVenda;
	private Date dataDaVenda;
	
	public Venda() {}

	public Venda(BigDecimal valorDaVenda, Date dataDaVenda) {
		super();
		this.valorDaVenda = valorDaVenda;
		this.dataDaVenda = dataDaVenda;
	}

	public BigDecimal getValorDaVenda() {
		return valorDaVenda;
	}

	public void setValorDaVenda(BigDecimal valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}

	public Date getDataDaVenda() {
		return dataDaVenda;
	}

	public void setDataDaVenda(Date dataDaVenda) {
		this.dataDaVenda = dataDaVenda;
	}
	
	/**
	 * 
	 * Metódo para calcular o valor que o vendedor irá receber encima dessa venda.
	 * 
	 * @param porcentagemDaVenda
	 * @return
	 */

	public BigDecimal getValorDaVenda(double porcentagemDaVenda) {
		return valorDaVenda.multiply(new BigDecimal(porcentagemDaVenda)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	/**
	 * 
	 * Metódo para comparar se a data informar é igual a data da venda.
	 * 
	 * @param dataMesAndAno
	 * @return
	 */
	public boolean compararData(Date dataMesAndAno) {
		return this.dataDaVenda.compareTo(dataMesAndAno) == 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDaVenda == null) ? 0 : dataDaVenda.hashCode());
		result = prime * result + ((valorDaVenda == null) ? 0 : valorDaVenda.hashCode());
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
		if (dataDaVenda == null) {
			if (other.dataDaVenda != null)
				return false;
		} else if (!dataDaVenda.equals(other.dataDaVenda))
			return false;
		if (valorDaVenda == null) {
			if (other.valorDaVenda != null)
				return false;
		} else if (!valorDaVenda.equals(other.valorDaVenda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [VALOR = " + valorDaVenda + ", DATA DA VENDA = " + DataUtil.formatar(dataDaVenda, "MM/yyyy") + "]";
	}
	
	

}
