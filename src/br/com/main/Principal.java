package br.com.main;

import br.com.mockers.AdicionarCargos;
import br.com.mockers.AdicionarVendas;
import br.com.mockers.AdiconarFuncionarios;
import br.com.service.FuncionarioService;
import br.com.util.DataUtil;
import br.com.util.VerificadorUtil;

public class Principal {

	public static void main(String[] args) {
		AdicionarCargos ac = new AdicionarCargos();
		AdiconarFuncionarios af = new AdiconarFuncionarios();
		AdicionarVendas av = new AdicionarVendas();

		ac.adicionarCargos();
		//ac.exibirDado();

		af.adicionarFuncionarios();
		//af.exibirDado();

		av.adicionarVendas();

		System.err.println("INICIO DO PRIMEIRO MÉTODO ");
		VerificadorUtil.retornarOValorTotalPagoDeSalarioComBeneficioNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("TÉRMINO DO PRIMEIRO MÉTODO ");
		System.out.println("\n");
		
		
		System.err.println("INICIO DO SEGUNDO MÉTODO ");
		VerificadorUtil.retornarSomenteOTotalPagoEmSalariosNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("TÉRMINO DO SEGUNDO MÉTODO ");
		System.out.println("\n");
		
		
		System.err.println("TERCEIRO MÉTODO ");
		VerificadorUtil.retornarSomenteOsFuncionariosQueRecebemBeneficioEOTotalPagoEmBeneficiosNoMes(
				FuncionarioService.getFuncionarios(), DataUtil.createDateMesAno("04/2022"));
		System.err.println("TÉRMINO DO TERCEIRO MÉTODO ");
		System.out.println("\n");
		
		
		System.err.println("QUARTO MÉTODO ");
		VerificadorUtil.retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("TÉRMINO DO QUARTO MÉTODO ");
		System.out.println("\n");
		
		
		System.err.println("QUINTO MÉTODO ");
		VerificadorUtil.retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoEmBEneficiosNoMes(
				FuncionarioService.getFuncionarios(), DataUtil.createDateMesAno("04/2022"));
		System.err.println("TÉRMINO DO QUINTO MÉTODO ");
		System.out.println("\n");
		
		
		System.err.println("SEXTO MÉTODO ");
		VerificadorUtil.retornarSomenteOFuncionarioQueVendeuMaisNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("TÉRMINO DO SEXTO MÉTODO ");

	}
}
