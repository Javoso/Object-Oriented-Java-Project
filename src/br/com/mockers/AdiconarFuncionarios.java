package br.com.mockers;

import br.com.builder.FuncionarioBuilder;
import br.com.service.FuncionarioService;
import br.com.util.DataUtil;
import br.com.service.CargoService;

public class AdiconarFuncionarios {

	private FuncionarioService service = new FuncionarioService();
	private CargoService serviceCargo = new CargoService();
	
	private DataUtil util = new DataUtil();

	public void adicionarFuncionarios() {
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Jorge Carvalho")
				.funcionarioComDataDeContratacao(util.createDateMesAno("01/2018"))
				.funcionarioComCargo(serviceCargo.findByCargo(0))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Maria Souza")
				.funcionarioComDataDeContratacao(util.createDateMesAno("01/2015"))
				.funcionarioComCargo(serviceCargo.findByCargo(0))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Ana Silva")
				.funcionarioComDataDeContratacao(util.createDateMesAno("12/2021"))
				.funcionarioComCargo(serviceCargo.findByCargo(1))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("João Mendes")
				.funcionarioComDataDeContratacao(util.createDateMesAno("01/2021"))
				.funcionarioComCargo(serviceCargo.findByCargo(1))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Juliana Alves")
				.funcionarioComDataDeContratacao(util.createDateMesAno("07/2017"))
				.funcionarioComCargo(serviceCargo.findByCargo(2))
				.getNovoFuncionario());
		
		service.adicionarFuncionario(
				new FuncionarioBuilder()
				.funcionarioComNome("Bento Albino")
				.funcionarioComDataDeContratacao(util.createDateMesAno("03/2014"))
				.funcionarioComCargo(serviceCargo.findByCargo(2))
				.getNovoFuncionario());
	}
	

	public void exibirDado() {
		service.listarFuncionarios();
	}

}
