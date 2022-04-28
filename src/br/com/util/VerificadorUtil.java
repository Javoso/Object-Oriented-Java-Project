package br.com.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.model.Funcionario;

/**
 * 
 * @author O Javoso
 *
 */

public class VerificadorUtil {

	public static void retornarOValorTotalPagoDeSalarioComBeneficioNoMes(List<Funcionario> funcionarios, Date data) {

		funcionarios.forEach(func -> {
			try {
				System.out.println("--------------------------------------------------");
				System.out.println("Nome: " + func.getNomeDoFuncionario());
				System.out.println(
						"Valor pago em " + DataUtil.formatar(data, "MM/yyyy") + " é de R$ " + func.totalASerPago(data));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println("--------------------------------------------------");
	}

	public static void retornarSomenteOTotalPagoEmSalariosNoMes(List<Funcionario> funcionarios, Date data) {
		funcionarios.forEach(func -> {
			try {
				System.out.println("--------------------------------------------------");
				System.out.println("Nome: " + func.getNomeDoFuncionario());
				System.out.println("Valor pago em " + DataUtil.formatar(data, "MM/yyyy") + " é de R$ "
						+ func.calcularValorDoSalario(data));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		System.out.println("--------------------------------------------------");

	}

	public static void retornarSomenteOsFuncionariosQueRecebemBeneficioEOTotalPagoEmBeneficiosNoMes(
			List<Funcionario> funcionarios, Date data) {
		funcionarios.stream().filter(funcionario -> funcionario.getCargoDoFuncionario().temBeneficio())
				.forEach(func -> {
					try {
						System.out.println("--------------------------------------------------");
						System.out.println("Nome: " + func.getNomeDoFuncionario());
						System.out.println("Valor pago em " + DataUtil.formatar(data, "MM/yyyy") + " é de R$ "
								+ func.calcularValorDoBeneficio(data));
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		System.out.println("--------------------------------------------------");

	}

	public static void retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoNoMes(List<Funcionario> funcionarios,
			Date data) {
		Funcionario func = funcionarios.stream()
				.sorted((o1, o2) -> o1.totalASerPago(data).compareTo(o2.totalASerPago(data)))
				.collect(Collectors.toList()).get(funcionarios.size() - 1);

		try {
			System.out.println("--------------------------------------------------");
			System.out.println("Nome: " + func.getNomeDoFuncionario());
			System.out.println(
					"Valor pago em " + DataUtil.formatar(data, "MM/yyyy") + " é de R$ " + func.totalASerPago(data));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------");
	}

	public static void retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoEmBEneficiosNoMes(
			List<Funcionario> funcionarios, Date data) {
		int var = funcionarios.stream().filter(funcionario -> funcionario.getCargoDoFuncionario().temBeneficio())
				.collect(Collectors.toList()).size() - 1;

		Funcionario func = funcionarios.stream()
				.filter(funcionario -> funcionario.getCargoDoFuncionario().temBeneficio())
				.sorted((o1, o2) -> o1.totalASerPago(data).compareTo(o2.totalASerPago(data)))
				.collect(Collectors.toList()).get(var);

		try {
			System.out.println("--------------------------------------------------");
			System.out.println("Nome: " + func.getNomeDoFuncionario());
			System.out.println("Valor pago em " + DataUtil.formatar(data, "MM/yyyy") + " é de R$ "
					+ func.calcularValorDoBeneficio(data));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------");

	}

	public static void retornarSomenteOFuncionarioQueVendeuMaisNoMes(List<Funcionario> funcionarios, Date data) {
		int var = funcionarios.stream().filter(funcionario -> funcionario.getCargoDoFuncionario().isVendendor())
				.collect(Collectors.toList()).size() - 1;

		Funcionario func = funcionarios.stream()
				.filter(funcionario -> funcionario.getCargoDoFuncionario().isVendendor()).sorted((o1, o2) -> o1
						.totalValorRecebidoPorVendas(data).compareTo(o2.totalValorRecebidoPorVendas(data)))
				.collect(Collectors.toList()).get(var);

		try {
			System.out.println("--------------------------------------------------");
			System.out.println("Nome: " + func.getNomeDoFuncionario());
			System.out.println("Valor pago em " + DataUtil.formatar(data, "MM/yyyy") + " é de R$ "
					+ func.totalValorRecebidoPorVendas(data));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------");
	}

}
