package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.exception.VendaException;
import br.com.util.DataUtil;

/**
 * 
 * Classe model Funcionaro com seu atributos e metódos.
 * 
 * @author O Javoso
 *
 */

public class Funcionario implements Serializable {

	private static final long serialVersionUID = 2154476051935899931L;
	private String nomeDoFuncionario;
	private Cargo cargoDoFuncionario;
	private Date dataDaContratacao;
	private List<Venda> vendas = new ArrayList<Venda>();

	/**
	 * Construtor com paramentros para inicializar o objeto.
	 * 
	 * @param nomeDoFuncionario
	 * @param cargoDoFuncionario
	 * @param dataDaContratacao
	 * @param vendas
	 */
	public Funcionario(String nomeDoFuncionario, Cargo cargoDoFuncionario, Date dataDaContratacao) {
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.cargoDoFuncionario = cargoDoFuncionario;
		this.dataDaContratacao = dataDaContratacao;
	}
	
	public Funcionario() {}

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

	/**
	 * 
	 * Metódo para a listar os dados referentes aos funcionarios.
	 * 
	 * @param dataMesAndAno
	 * @return
	 * @throws Exception
	 */

	public String listar(Date dataMesAndAno) throws Exception {
		return new StringBuilder()
				.append("{ \n")
				.append("NOME: ").append(getNomeDoFuncionario())
				.append("\n")
				.append("CARGO: ").append(getCargoDoFuncionario().getNomeCargo())
				.append("\n")
				.append("BENEFICIO: ").append((getCargoDoFuncionario().getPorcentagemBeneficio() * 100) + "%")
				.append("\n")
				.append("SALARIO: ").append(getCargoDoFuncionario().getSalario())
				.append("\n")
				.append("ABONO: ").append(getCargoDoFuncionario().getValorDeAbonoAnual())
				.append("\n")
				.append("DATA DE CONTRATO: ").append(DataUtil.formatar(this.getDataDaContratacao(), "MM/yyyy"))
				.append("\n")
				.append("VALOR DO SALARIO: ").append(this.calcularValorDoSalario(dataMesAndAno))
				.append("\n")
				.append("VALOR DO BENEFICIOS: ").append(this.calcularValorDoBeneficio(dataMesAndAno))
				.append("\n")
				.append("VALOR DAS VENDAS: ").append(this.totalValorRecebidoPorVendas(dataMesAndAno))
				.append("\n")
				.append("VALOR TOTAL A RECEBER POR TEMPO DE SERVIÇO: ").append(this.totalDeBonusPorTempoDeServico(dataMesAndAno))
				.append("\n")
				.append("TOTAL DO PAGO AO FUNCIONARIO: ").append(this.totalASerPago(dataMesAndAno))
				.append("\n }")
				.toString();
	}

	/**
	 * Metódo para retornar o valor total do salario mais o benefecio do
	 * funcionario.
	 * 
	 * @param dataMesAndAno
	 * @return
	 */

	public BigDecimal totalASerPago(Date dataMesAndAno) {
		return this.calcularValorDoSalario(dataMesAndAno).add(calcularValorDoBeneficio(dataMesAndAno));
	}

	/**
	 * Metódo para retornar o valor do salario do funcionario.
	 * 
	 * @param dataMesAndAno
	 * @return
	 */

	public BigDecimal calcularValorDoSalario(Date dataMesAndAno) {
		return this.cargoDoFuncionario.getSalario().add(totalDeBonusPorTempoDeServico(dataMesAndAno));
	}

	/**
	 * Metódo para retornar o valor total do beneficio do funcionario.
	 * 
	 * @param dataMesAndAno
	 * @return
	 */
	public BigDecimal calcularValorDoBeneficio(Date dataMesAndAno) {
		if (this.cargoDoFuncionario.isSecretario()) {
			return calcularValorBeneficioSecretario(dataMesAndAno);
		} else if (this.cargoDoFuncionario.isVendendor()) {
			return calcularValorBeneficioVendedor(dataMesAndAno);
		} else {
			return calcularValorBeneficioGerente(dataMesAndAno);
		}

	}

	/**
	 * 
	 * Método para realizar o calculo do valor referente ao beneficio que o vendedor
	 * irá receber
	 * 
	 * @param dataMesAndAno
	 * @return
	 */
	public BigDecimal calcularValorBeneficioVendedor(Date dataMesAndAno) {
		if (!verificaSeTemVenda(dataMesAndAno))
			return new BigDecimal(0);

		return totalValorRecebidoPorVendas(dataMesAndAno);
	}

	/**
	 * 
	 * Método para realizar o calculo do valor referente ao beneficio que o
	 * secretário irá receber
	 * 
	 * @param dataMesAndAno
	 * @return
	 */

	public BigDecimal calcularValorBeneficioSecretario(Date dataMesAndAno) {
		return calcularValorDoSalario(dataMesAndAno).add(valorBeneficioSobreSalario(dataMesAndAno));
	}

	/**
	 * 
	 * Método para realizar o calculo do valor referente ao beneficio que o gerente
	 * irá receber
	 * 
	 * @param dataMesAndAno
	 * @return
	 */
	public BigDecimal calcularValorBeneficioGerente(Date dataMesAndAno) {
		return calcularValorDoSalario(dataMesAndAno);
	}

	/**
	 * 
	 * Método para verificar se o funcionario tem alguma venda.
	 * 
	 * @param dataMesAndAno
	 * @return
	 */
	public boolean verificaSeTemVenda(Date dataMesAndAno) {
		boolean a = this.vendas.stream().anyMatch(venda -> venda.compararData(dataMesAndAno));
		return a;
	}

	/**
	 * Metódo para calcular o valor que o funcionário irá receber com base no tempo
	 * de servico prestado entre a data de sua contratação e a data que foi passada
	 * por paramêtro.
	 * 
	 * @param dataMesAndAno
	 */
	public BigDecimal totalDeBonusPorTempoDeServico(Date dataMesAndAno) {
		long tempoEmAnoDeTrabalho = DataUtil.numeroDeAnosEntreDatas(this.dataDaContratacao, dataMesAndAno);

		return this.cargoDoFuncionario.getValorDeAbonoAnual()
				.multiply(new BigDecimal(tempoEmAnoDeTrabalho > 0 ? tempoEmAnoDeTrabalho : 0));

	}

	/**
	 * 
	 * Método para realizar o calculo do valor referente ao beneficio que o
	 * funcionario irá receber encima do seu salario.
	 * 
	 * @param dataMesAndAno
	 * @return
	 */

	public BigDecimal valorBeneficioSobreSalario(Date dataMesAndAno) {
		return calcularValorDoSalario(dataMesAndAno)
				.multiply(new BigDecimal(this.cargoDoFuncionario.getPorcentagemBeneficio()))
				.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * Método para realizar o calculo do valor que o vendedor irá receber pela sua
	 * vendas
	 * 
	 * @param dataMesAndAno
	 * @return
	 * @throws VendaException
	 */

	public BigDecimal totalValorRecebidoPorVendas(Date dataMesAndAno) throws VendaException {

		if (this.cargoDoFuncionario.getNomeCargo().equalsIgnoreCase("VENDEDOR")) {
			if (!verificaSeTemVenda(dataMesAndAno))
				return new BigDecimal(0);

			List<Venda> vendaUtil = vendas.stream().filter(venda -> venda.getDataDaVenda().equals(dataMesAndAno))
					.collect(Collectors.toList());

			return vendaUtil.stream().map(venda -> venda.getValorDaVenda(cargoDoFuncionario.getPorcentagemBeneficio()))
					.reduce(BigDecimal.ZERO, BigDecimal::add);

		} else {
			return new BigDecimal(0);
		}

	}

	@Override
	public String toString() {
		return "Funcionario [ NOME = " + nomeDoFuncionario + ", CARGO =" + cargoDoFuncionario
				+ ", DATA DE CONTRATAÇÃO =" +  DataUtil.formatar(dataDaContratacao, "MM/yyyy") + ", VENDAS =" + vendas + "]";
	}
	
	

}
