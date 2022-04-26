package br.com.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario {

	private String nomeDoFuncionario;
	private Cargo cargoDoFuncionario;
	private Date dataDaContratacao;
	private List<Venda> vendas = new ArrayList<Venda>();

	public Funcionario(String nomeDoFuncionario, Cargo cargoDoFuncionario, Date dataDaContratacao) {
		super();
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.cargoDoFuncionario = cargoDoFuncionario;
		this.dataDaContratacao = dataDaContratacao;
	}

	public String getNomeDoFuncionario() {
		return nomeDoFuncionario;
	}

	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
	}

	public Cargo getCargoDoFuncionario() {
		return cargoDoFuncionario;
	}

	public void setCargoDoFuncionario(Cargo cargoDoFuncionario) {
		this.cargoDoFuncionario = cargoDoFuncionario;
	}

	public Date getDataDaContratacao() {
		return dataDaContratacao;
	}

	public void setDataDaContratacao(Date dataDaContratacao) {
		this.dataDaContratacao = dataDaContratacao;
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Funcionario addVenda(Venda venda) {
		this.vendas.add(venda);
		return this;
	}

	public BigDecimal valorTotalAReceber() throws Exception {
		return totalDoSalario().add(totalValorrecebidoPorVenda());
	}

	public BigDecimal totalDoSalario() {
		return this.cargoDoFuncionario.getSalario().add(
				this.cargoDoFuncionario.getValorDeAbonoAnual().divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP));
	}

	public BigDecimal totalValorrecebidoPorVenda() throws Exception {
		if (vendas.isEmpty())
			throw new Exception("Erro");

		BigDecimal total = new BigDecimal(0);

		vendas.forEach(venda -> total
				.add(venda.getValorDaVenda().multiply(new BigDecimal(cargoDoFuncionario.getPorcentagemBeneficio()))));

		return total;
	}

}
