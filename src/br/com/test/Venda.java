package br.com.test;

import java.math.BigDecimal;
import java.util.Date;

public class Venda {

	private BigDecimal valorDaVenda;
	private Date dataDaVenda;

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

	public BigDecimal getValorDaVenda(double porcentagemDaVenda) {
		return valorDaVenda.multiply(new BigDecimal(porcentagemDaVenda)).setScale(2, BigDecimal.ROUND_DOWN);
	}

}
