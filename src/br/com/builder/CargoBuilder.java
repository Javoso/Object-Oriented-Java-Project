package br.com.builder;

import java.math.BigDecimal;

import br.com.model.Cargo;

/**
 * 
 * Classe CargoBuilder � utilizado para a cri��o de um ou v�rios objetos com muitas op��es poss�veis de inicializa��o.
 * 
 * @author O Javoso
 *
 */

public class CargoBuilder {

	private Cargo cargo;

	public CargoBuilder() {
		cargo = new Cargo();
	}

	public CargoBuilder cargoComNome(String nome) {
		cargo.setNomeCargo(nome);
		return this;
	}

	public CargoBuilder cargoComPorcentagemBeneficio(float porcentagem) {
		cargo.setPorcentagemBeneficio((porcentagem/100));
		return this;
	}

	public CargoBuilder cargoComSalario(BigDecimal salario) {
		cargo.setSalario(salario.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}
	
	public CargoBuilder cargoComTaxaDeAnoDeServico(BigDecimal valorTaxa) {
		cargo.setAdicaoPorTempoDeServico(valorTaxa.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}

	public Cargo getNovoCargo() {
		return cargo;
	}

}
