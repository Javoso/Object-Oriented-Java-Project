package br.com.builder;

import java.math.BigDecimal;

import br.com.model.Cargo;

/**
 * 
 * Classe CargoBuilder é utilizado para a crição de um ou vários objetos com
 * muitas opções possíveis de inicialização.
 * 
 * @author O Javoso
 *
 */

public class CargoBuilder {

	private Cargo cargo;

	public CargoBuilder() {
		cargo = new Cargo();
	}

	/**
	 * Adiciona um nome para o cargo e retorna o objeto da classe CargoBuilder
	 * 
	 * @param nome
	 * @return
	 */

	public CargoBuilder cargoComNome(String nome) {
		cargo.setNomeCargo(nome);
		return this;
	}

	/**
	 * Adiciona uma porcentagem de beneficio para o cargo e retorna o objeto da
	 * classe CargoBuilder
	 * 
	 * @param porcentagem
	 * @return
	 */

	public CargoBuilder cargoComPorcentagemBeneficio(float porcentagem) {
		cargo.setPorcentagemBeneficio((porcentagem / 100));
		return this;
	}

	/**
	 * Adiciona o salário para o cargo e retorna o objeto da classe CargoBuilder
	 * 
	 * @param salario
	 * @return
	 */
	public CargoBuilder cargoComSalario(BigDecimal salario) {
		cargo.setSalario(salario.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}

	/**
	 * 
	 * Adiciona a taxa de ano de servico para o cargo e retorna o objeto da classe
	 * CargoBuilder
	 * 
	 * @param valorTaxa
	 * @return
	 */
	public CargoBuilder cargoComTaxaDeAnoDeServico(BigDecimal valorTaxa) {
		cargo.setAdicaoPorTempoDeServico(valorTaxa.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}

	/**
	 * Retorna o objeto criado da classe Cargo com os valor que foram setados nele.
	 * 
	 * @return
	 */
	public Cargo getNovoCargo() {
		return cargo;
	}

}
