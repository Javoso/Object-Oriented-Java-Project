package br.com.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.model.Funcionario;

/**
 * 
 * @author O Javoso
 *
 */

public class VerificadorUtil {

	public static BigDecimal retornarOValorTotalPagoDeSalarioComBeneficioNoMes(List<Funcionario> funcionarios,
			Date dataMes) {

		funcionarios.forEach(fun -> {
			System.err.println(fun.getNomeDoFuncionario());
			System.err.println(fun.getCargoDoFuncionario().valorDoAnoDeServicoEmMes());
			System.err.println(fun.valorTotalAReceberPorMes());
		});
		
		

		return funcionarios.stream().map(Funcionario::valorTotalAReceber).reduce(BigDecimal.ZERO,
				BigDecimal::add);
	}

	public static BigDecimal retornarSomenteOTotalPagoEmSalariosNoMes(List<Funcionario> funcionarios, Date dataMes) {
		return funcionarios.stream().map(Funcionario::getValorDoSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public static BigDecimal retornarSomenteOsFuncionariosQueRecebemBeneficioEOTotalPagoEmBeneficiosNoMes(
			List<Funcionario> funcionarios, Date dataMes) {

		return funcionarios.stream().map(Funcionario::getValorDoBeneficio).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public static BigDecimal retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoNoMes(List<Funcionario> funcionarios,
			Date dataMes) {
		return funcionarios.stream().map(Funcionario::getValorDoBeneficio).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public static BigDecimal retornarSomenteOFuncionarioQueRecebeuOValorMaisAltoEmBEneficiosNoMes(
			List<Funcionario> funcionarios, Date dataMes) {
		return funcionarios.stream().map(Funcionario::getValorDoBeneficio).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public static BigDecimal retornarSomenteOFuncionarioQueVendeuMaisNoMes(List<Funcionario> funcionarios, Date dataMes) {		
		return funcionarios.stream().map(Funcionario::getValorDoBeneficio).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
