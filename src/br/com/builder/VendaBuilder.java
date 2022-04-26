package br.com.builder;

import java.math.BigDecimal;

import br.com.model.Cargo;

/**
 * 
 * Classe CargoBuilder é utilizado para a crição de um ou vários objetos com muitas opções possíveis de inicialização.
 * 
 * @author O Javoso
 *
 */

public class VendaBuilder {

	private Cargo cargo;

	public VendaBuilder() {
		cargo = new Cargo();
	}

	public VendaBuilder cargoComNome(String nome) {
		cargo.setNomeCargo(nome);
		return this;
	}

	public VendaBuilder cargoComPorcentagemBeneficio(float porcentagem) {
		cargo.setPorcentagemBeneficio((porcentagem/100));
		return this;
	}

	public VendaBuilder cargoComSalario(BigDecimal salario) {
		cargo.setSalario(salario.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}
	
	public VendaBuilder cargoComTaxaDeAnoDeServico(BigDecimal valorTaxa) {
		cargo.setAdicaoPorTempoDeServico(valorTaxa.setScale(2, BigDecimal.ROUND_DOWN));
		return this;
	}

	public Cargo getNovoCargo() {
		return cargo;
	}

}
