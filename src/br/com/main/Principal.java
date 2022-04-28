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

		System.err.println("INICIO DO PRIMEIRO M�TODO ");
		VerificadorUtil.retornarOValorTotalPagoDeSalarioComBeneficioNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("T�RMINO DO PRIMEIRO M�TODO ");
		System.out.println("\n");
		
		
		System.err.println("INICIO DO SEGUNDO M�TODO ");
		VerificadorUtil.retornarSomenteOTotalPagoEmSalariosNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("T�RMINO DO SEGUNDO M�TODO ");
		System.out.println("\n");
		
		
		System.err.println("TERCEIRO M�TODO ");
		VerificadorUtil.retornarSomenteOsFuncionariosQueRecebemBeneficioEOTotalPagoEmBeneficiosNoMes(
				FuncionarioService.getFuncionarios(), DataUtil.createDateMesAno("04/2022"));
		System.err.println("T�RMINO DO TERCEIRO M�TODO ");
		System.out.println("\n");
		
		
		System.err.println("QUARTO M�TODO ");
		VerificadorUtil.retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("T�RMINO DO QUARTO M�TODO ");
		System.out.println("\n");
		
		
		System.err.println("QUINTO M�TODO ");
		VerificadorUtil.retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoEmBEneficiosNoMes(
				FuncionarioService.getFuncionarios(), DataUtil.createDateMesAno("04/2022"));
		System.err.println("T�RMINO DO QUINTO M�TODO ");
		System.out.println("\n");
		
		
		System.err.println("SEXTO M�TODO ");
		VerificadorUtil.retornarSomenteOFuncionarioQueVendeuMaisNoMes(FuncionarioService.getFuncionarios(),
				DataUtil.createDateMesAno("04/2022"));
		System.err.println("T�RMINO DO SEXTO M�TODO ");

	}
}
