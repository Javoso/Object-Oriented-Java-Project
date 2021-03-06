package br.com.mockers;

import static br.com.util.DataUtil.createDateMesAno;

import br.com.builder.FuncionarioBuilder;
import br.com.service.CargoService;
import br.com.service.FuncionarioService;

/**
 * 
 * @author O Javoso
 *
 */

public class AdiconarFuncionarios {

	private FuncionarioService service = new FuncionarioService();
	private CargoService serviceCargo = new CargoService();
	
	public void adicionarFuncionarios() {
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Jorge Carvalho")
				.funcionarioComDataDeContratacao(createDateMesAno("01/2018"))
				.funcionarioComCargo(serviceCargo.findByCargo(0))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Maria Souza")
				.funcionarioComDataDeContratacao(createDateMesAno("01/2015"))
				.funcionarioComCargo(serviceCargo.findByCargo(0))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Ana Silva")
				.funcionarioComDataDeContratacao(createDateMesAno("12/2021"))
				.funcionarioComCargo(serviceCargo.findByCargo(1))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Jo?o Mendes")
				.funcionarioComDataDeContratacao(createDateMesAno("01/2021"))
				.funcionarioComCargo(serviceCargo.findByCargo(1))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Juliana Alves")
				.funcionarioComDataDeContratacao(createDateMesAno("07/2017"))
				.funcionarioComCargo(serviceCargo.findByCargo(2))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Bento Albino")
				.funcionarioComDataDeContratacao(createDateMesAno("03/2014"))
				.funcionarioComCargo(serviceCargo.findByCargo(2))
				.getNovoFuncionario());
	}
	

	public void exibirDado() {
		service.listarFuncionarios();
	}
	
}
