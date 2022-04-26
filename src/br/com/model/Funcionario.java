package br.com.model;

import static java.util.Objects.isNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.util.DataUtil;

/**
 * 
 * Classe model Funcionaro com seu atributos e metódos.
 * 
 * @author O Javoso
 *
 */
public class Funcionario {

	private String nomeDoFuncionario;
	private Cargo cargoDoFuncionario;
	private Date dataDaContratacao;
	private List<Venda> vendas;

	public Funcionario() {
	}

	/**
	 * Construtor com paramentros para inicializar o objeto.
	 * 
	 * @param nomeDoFuncionario
	 * @param cargoDoFuncionario
	 * @param dataDaContratacao
	 * @param vendas
	 */

	public Funcionario(String nomeDoFuncionario, Cargo cargoDoFuncionario, Date dataDaContratacao, List<Venda> vendas) {
		super();
		this.nomeDoFuncionario = nomeDoFuncionario;
		this.cargoDoFuncionario = cargoDoFuncionario;
		this.dataDaContratacao = dataDaContratacao;
		this.vendas = vendas;
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
		if (isNull(vendas))
			vendas = new ArrayList<>();
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public void adicionarVendaAoFuncionario(Venda venda) {

	}

	/**
	 * Metódo para retornar o valor do salario do funcionario.
	 * 
	 * @return
	 */
	public BigDecimal getValorDoSalario() {
		return this.cargoDoFuncionario.getValorDoSalario();
	}

	/**
	 * Metódo para verificar se o funcionario tem beneficios.
	 * 
	 * @return
	 */
	public boolean temNaoBeneficios() {
		return this.cargoDoFuncionario.getValorDoBeneficio() != BigDecimal.ZERO;
	}

	/**
	 * Metódo para retornar o valor total do salario mais o benefecio do
	 * funcionario.
	 * 
	 * @return
	 */
	public BigDecimal getValorDoSalarioComBeneficio() {
		return this.cargoDoFuncionario.getValorDoSalarioComBeneficio();
	}

	/**
	 * Metódo para retornar o valor total do beneficio do funcionario.
	 * 
	 * @return
	 */
	public BigDecimal getValorDoBeneficio() {
		return this.cargoDoFuncionario.getValorDoBeneficio();
	}

	/**
	 * Metódo para calcular o valor que o funcionário irá receber com base no tempo
	 * de servico prestado entre a data de sua contratação e a data que foi passada
	 * por paramêtro.
	 * 
	 * @param dataAtual
	 */
	public void calcularValorAdicionalDoTempoDeServico(Date dataAtual) {
		this.cargoDoFuncionario.getValorTotalDeAdicionalPorTempodeServico(calcularTempoDeServico(dataAtual));
	}

	/**
	 * 
	 * Metódo para a calcular o valor total que o funcionario irá receber no
	 * pagamento de suas contas.
	 * 
	 * @return
	 */
	public BigDecimal valorTotalAReceber() {
		return this.cargoDoFuncionario.valorTotalAReceber();
	}

	/**
	 * Metódo para compara o tempo de trabalho do funcionario em anos.
	 * 
	 * @param dataAtual
	 * @return
	 */

	public int calcularTempoDeServico(Date dataAtual) {
		return new DataUtil().qtdAnosEntreDatas(dataDaContratacao, dataAtual);
	}

	/**
	 * 
	 * Metodo para verificar se o valor paramentro é igual ao nme do funcionario.
	 * 
	 * @param nome
	 * @return
	 */
	public boolean verificarSeOsNomesSaoIguais(String nome) {
		return this.nomeDoFuncionario.equalsIgnoreCase(nome);
	}

	/**
	 * 
	 * Metódo para a calcular o valor total que o funcionario irá receber no mes
	 * pagamento de suas contas.
	 * 
	 * @return
	 */
	public BigDecimal valorTotalAReceberPorMes() {
		return this.cargoDoFuncionario.getValorDoSalarioComBeneficio();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargoDoFuncionario == null) ? 0 : cargoDoFuncionario.hashCode());
		result = prime * result + ((dataDaContratacao == null) ? 0 : dataDaContratacao.hashCode());
		result = prime * result + ((nomeDoFuncionario == null) ? 0 : nomeDoFuncionario.hashCode());
		result = prime * result + ((vendas == null) ? 0 : vendas.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (cargoDoFuncionario == null) {
			if (other.cargoDoFuncionario != null)
				return false;
		} else if (!cargoDoFuncionario.equals(other.cargoDoFuncionario))
			return false;
		if (dataDaContratacao == null) {
			if (other.dataDaContratacao != null)
				return false;
		} else if (!dataDaContratacao.equals(other.dataDaContratacao))
			return false;
		if (nomeDoFuncionario == null) {
			if (other.nomeDoFuncionario != null)
				return false;
		} else if (!nomeDoFuncionario.equals(other.nomeDoFuncionario))
			return false;
		if (vendas == null) {
			if (other.vendas != null)
				return false;
		} else if (!vendas.equals(other.vendas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return " Funcionario { \n Nome do Funcionario : " + nomeDoFuncionario
				+ ",\n Data de Contratação do Funcionario : " + new DataUtil().formatar(dataDaContratacao, "MM/yyyy")
				+ ",\n Dados do Cargo do Funcionario : " + cargoDoFuncionario + "\n }";
	}

}
