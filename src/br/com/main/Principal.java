package br.com.main;

import static br.com.service.FuncionarioService.getFuncionarios;
import static br.com.util.DataUtil.createDateMesAno;
import static br.com.util.VerificadorUtil.retornarOValorTotalPagoDeSalarioComBeneficioNoMes;
import static br.com.util.VerificadorUtil.retornarSomenteOTotalPagoEmSalariosNoMes;
import static br.com.util.VerificadorUtil.retornarSomenteOsFuncionariosQueRecebemBeneficioEOTotalPagoEmBeneficiosNoMes;

import java.util.List;
import java.util.stream.Collectors;

import br.com.mockers.AdicionarCargos;
import br.com.mockers.AdicionarVendas;
import br.com.mockers.AdiconarFuncionarios;
import br.com.model.Funcionario;

public class Principal {

	public static void main(String[] args) {
		AdicionarCargos ac = new AdicionarCargos();
		AdiconarFuncionarios af = new AdiconarFuncionarios();
		AdicionarVendas av = new AdicionarVendas();

		ac.adicionarCargos();
		ac.exibirDado();

		af.adicionarFuncionarios();
		af.exibirDado();

		av.adicionarVendas();
		// av.exibirDado();

		// av.vendasPorVendedor("Jorge Carvalho").forEach(System.out::println);
		// av.vendasPorVendedor("Maria Souza ").forEach(System.out::println);
		// av.vendasPorVendedor("Ana Silva").forEach(System.out::println);
		// av.vendasPorVendedor("João Mendes").forEach(System.out::println);
		// av.vendasPorVendedor("Juliana Alves ").forEach(System.out::println);
		// av.vendasPorVendedor("Bento Albino").forEach(System.out::println);

		List<Funcionario> funcionariosSemBeneficios = getFuncionarios().stream().filter(func -> func.temNaoBeneficios())
				.collect(Collectors.toList());

		System.out.println("O Valor da soma do salario é: R$"
				+ retornarOValorTotalPagoDeSalarioComBeneficioNoMes(getFuncionarios(), createDateMesAno("01/2022")));

		System.out.println("O Valor da soma do salario com os beneficios é: R$"
				+ retornarSomenteOTotalPagoEmSalariosNoMes(getFuncionarios(), createDateMesAno("01/2022")));

		System.out.println("A soma do valor recebido pelos funcionarios que tem beneficios é: R$"
				+ retornarSomenteOsFuncionariosQueRecebemBeneficioEOTotalPagoEmBeneficiosNoMes(
						funcionariosSemBeneficios, createDateMesAno("01/2022")));

	}
}
