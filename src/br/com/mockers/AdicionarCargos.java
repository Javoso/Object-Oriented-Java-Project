package br.com.mockers;

import java.math.BigDecimal;

import br.com.builder.CargoBuilder;
import br.com.service.CargoService;

/**
 * 
 * @author O Javoso
 *
 */
public class AdicionarCargos {

	private CargoService service = new CargoService();

	public void adicionarCargos() {
		service.adicionarCargo(new CargoBuilder().cargoComNome("Secretário").cargoComPorcentagemBeneficio(20)
				.cargoComSalario(new BigDecimal(7000)).cargoComTaxaDeAnoDeServico(new BigDecimal(1000)).getNovoCargo());
		
		service.adicionarCargo(new CargoBuilder().cargoComNome("Vendedor").cargoComPorcentagemBeneficio(30)
				.cargoComSalario(new BigDecimal(12000)).cargoComTaxaDeAnoDeServico(new BigDecimal(1800)).getNovoCargo());
		
		service.adicionarCargo(new CargoBuilder().cargoComNome("Gerente").cargoComPorcentagemBeneficio(0)
				.cargoComSalario(new BigDecimal(20000)).cargoComTaxaDeAnoDeServico(new BigDecimal(3000)).getNovoCargo());
	}
	
	public void exibirDado() {
		service.listarCargos();
	}

}
