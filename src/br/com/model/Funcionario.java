package br.com.model;

import java.math.BigDecimal;
import java.util.Date;

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

	public Funcionario() {
	}

	/**
	 * 
	 * Construtor com paramentros para inicializar o objeto.
	 * 
	 * @param nomeDoFuncionario
	 * @param cargoDoFuncionario
	 * @param dataDaContratacao
	 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargoDoFuncionario == null) ? 0 : cargoDoFuncionario.hashCode());
		result = prime * result + ((dataDaContratacao == null) ? 0 : dataDaContratacao.hashCode());
		result = prime * result + ((nomeDoFuncionario == null) ? 0 : nomeDoFuncionario.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return " Funcionario { \n Nome do Funcionario : " + nomeDoFuncionario
				+ ",\n Data de Contratação do Funcionario : " + dataDaContratacao
				+ ",\n Dados do Cargo do Funcionario : " + cargoDoFuncionario + "\n }";
	}

}
