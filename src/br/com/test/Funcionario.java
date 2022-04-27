package br.com.test;

import static java.util.Objects.isNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.util.DataUtil;

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

	public String listar(Date data) throws Exception {
		return new StringBuilder()
				.append("{\n")
				.append("NOME: ")
				.append(getNomeDoFuncionario())
				.append("\n")
				.append("CARGO: ")
				.append(getCargoDoFuncionario().getNomeCargo())
				.append("\n").append("BENEFICIO: ")
				.append(getCargoDoFuncionario().getPorcentagemBeneficio())
				.append("\n")
				.append("SALARIO: ").append(getCargoDoFuncionario().getSalario())
				.append("\n")
				.append("ABONO: ").append(getCargoDoFuncionario().getValorDeAbonoAnual())
				.append("\n")
				.append("DATA DE CONTRATO: ").append(this.getDataDaContratacao())
				
				.append("\n")
				.append("TOTAL DO SALARIO: ").append(this.totalDoSalario(data))
				
				.append("\n")
				.append("VALOR RECEBIDO DO SALARIO: ").append(this.totalValorRecebidoDoSalario(data))
				
				.append("\n")
				.append("VALOR TOTAL A RECEBER: ").append(this.valorTotalAReceber(data))
				
				.append("\n")
				.append("DATA DE CONTRATO: ").append(this.getDataDaContratacao())
				.append("\n}").toString();
	}

	public BigDecimal valorTotalAReceber(Date dataMes) throws Exception {

		if (cargoDoFuncionario.getNomeCargo().equalsIgnoreCase("VENDEDOR"))
			return totalDoSalario(dataMes).add(totalValorRecebidoPorVenda());

		else if (cargoDoFuncionario.getNomeCargo().equalsIgnoreCase("SECRETARIO"))
			return totalDoSalario(dataMes).add(totalValorRecebidoDoSalario(dataMes));

		else
			return totalDoSalario(dataMes).add(totalValorRecebidoPorVenda());
	}

	public BigDecimal totalDoSalario(Date dataMes) {
		
		BigDecimal a = this.cargoDoFuncionario.getValorDeAbonoAnual()
				.multiply(BigDecimal.valueOf(DataUtil.numeroDeDiasEntreDatas(dataDaContratacao, dataMes)))
				.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		
		return this.cargoDoFuncionario.getSalario().add(a);
	}

	public BigDecimal totalValorRecebidoDoSalario(Date dataMes) {
		return totalDoSalario(dataMes).multiply(new BigDecimal(cargoDoFuncionario.getPorcentagemBeneficio()))
				.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal totalValorRecebidoPorVenda() throws Exception {

		if (isNull(vendas))
			throw new Exception("Erro");

		return vendas.stream().map(venda -> venda.getValorDaVenda(cargoDoFuncionario.getPorcentagemBeneficio()))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}

}
