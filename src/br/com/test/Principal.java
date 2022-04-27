package br.com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.util.DataUtil;

public class Principal {

	public static void main(String[] args) {
		try {

			Cargo cargo1 = new Cargo("SECRETARIO", BigDecimal.valueOf(7000).setScale(2, BigDecimal.ROUND_HALF_UP), (20),
					BigDecimal.valueOf(1000).setScale(2, BigDecimal.ROUND_HALF_UP));

			Cargo cargo2 = new Cargo("VENDEDOR", BigDecimal.valueOf(12000).setScale(2, BigDecimal.ROUND_HALF_UP), (30),
					BigDecimal.valueOf(1800).setScale(2, BigDecimal.ROUND_HALF_UP));

			Cargo cargo3 = new Cargo("GERENTE", BigDecimal.valueOf(20000).setScale(2, BigDecimal.ROUND_HALF_UP), (0),
					BigDecimal.valueOf(3000).setScale(2, BigDecimal.ROUND_HALF_UP));

			Venda venda1 = new Venda(BigDecimal.valueOf(5200).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("12/2021"));
			Venda venda2 = new Venda(BigDecimal.valueOf(4000).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("01/2022"));
			Venda venda3 = new Venda(BigDecimal.valueOf(4200).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("02/2022"));
			Venda venda4 = new Venda(BigDecimal.valueOf(5850).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("03/2022"));
			Venda venda5 = new Venda(BigDecimal.valueOf(7000).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("04/2022"));

			Venda venda6 = new Venda(BigDecimal.valueOf(3400).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("12/2021"));
			Venda venda7 = new Venda(BigDecimal.valueOf(7700).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("01/2022"));
			Venda venda8 = new Venda(BigDecimal.valueOf(5000).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("02/2022"));
			Venda venda9 = new Venda(BigDecimal.valueOf(5900).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("03/2022"));
			Venda venda10 = new Venda(BigDecimal.valueOf(6500).setScale(2, BigDecimal.ROUND_HALF_UP),
					DataUtil.createDateMesAno("04/2022"));

			Funcionario funcionario1 = new Funcionario("Jorge Carvalho", cargo1, DataUtil.createDateMesAno("01/2018"));
			Funcionario funcionario2 = new Funcionario("Maria Souza", cargo1, DataUtil.createDateMesAno("12/2015"));

			Funcionario funcionario3 = new Funcionario("Ana Silva", cargo2, DataUtil.createDateMesAno("12/2021"))
					.addVenda(venda1).addVenda(venda2).addVenda(venda3).addVenda(venda4).addVenda(venda5);

			Funcionario funcionario4 = new Funcionario("João Mendes", cargo2, DataUtil.createDateMesAno("12/2021"))
					.addVenda(venda6).addVenda(venda7).addVenda(venda8).addVenda(venda9).addVenda(venda10);

			Funcionario funcionario5 = new Funcionario("Juliana Alves", cargo3, DataUtil.createDateMesAno("07/2017"));
			Funcionario funcionario6 = new Funcionario("Bento Albino", cargo3, DataUtil.createDateMesAno("03/2014"));

			List<Funcionario> funcionarios = new ArrayList<>();

			funcionarios.add(funcionario1);
			funcionarios.add(funcionario2);
			funcionarios.add(funcionario3);
			funcionarios.add(funcionario4);
			funcionarios.add(funcionario5);
			funcionarios.add(funcionario6);
			
			Date data = DataUtil.createDateMesAno("04/2022");

//			System.out.println(" Funcionario  - " + funcionario3.getNomeDoFuncionario() + "\n O seu Valor a receber é: "
//					+ funcionario3.valorTotalAReceber(data));
//			System.out.println(" Funcionario  - " + funcionario4.getNomeDoFuncionario() + "\n O seu Valor a receber é: "
//					+ funcionario4.valorTotalAReceber(data));

			metodo2(funcionarios, DataUtil.createDateMesAno("02/2022"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void metodo2(List<Funcionario> funcionarios, Date data) {
		funcionarios.forEach(func -> {
			try {
				System.out.println(func.getCargoDoFuncionario().getNomeCargo() + "\n"
						+ func.totalValorRecebidoDoSalario(data) 
						+ "\n" + func.totalValorRecebidoPorVenda()
						+ "\n" + func.totalDoSalario(data) 
						+ "\n" + func.valorTotalAReceber(data));
				
				System.out.println();
				System.out.println();
				System.out.println(func.listar(data));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
