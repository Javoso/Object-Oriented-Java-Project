package br.com.test;

import java.math.BigDecimal;

import br.com.util.DataUtil;

public class Principal {
	
	public static void main(String[] args) {
		try {

			Cargo cargo1 = new Cargo("SECRETARIO", BigDecimal.valueOf(7000).setScale(2, BigDecimal.ROUND_DOWN), (20),
					BigDecimal.valueOf(1000).setScale(2, BigDecimal.ROUND_DOWN));
		
			Cargo cargo2 = new Cargo("VENDEDOR", BigDecimal.valueOf(12000).setScale(2, BigDecimal.ROUND_DOWN), (30),
					BigDecimal.valueOf(1800).setScale(2, BigDecimal.ROUND_DOWN));
		
			Cargo cargo3 = new Cargo("GERENTE", BigDecimal.valueOf(20000).setScale(2, BigDecimal.ROUND_DOWN), (0),
					BigDecimal.valueOf(3000).setScale(2, BigDecimal.ROUND_DOWN));
		
			
			
			Venda venda1 = new Venda(BigDecimal.valueOf(5200).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("12/2021") );
			Venda venda2 = new Venda(BigDecimal.valueOf(4000).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("01/2022") );
			Venda venda3 = new Venda(BigDecimal.valueOf(4200).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("02/2022") );
			Venda venda4 = new Venda(BigDecimal.valueOf(5850).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("03/2022") );
			Venda venda5 = new Venda(BigDecimal.valueOf(7000).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("04/2022") );
		
		
			Venda venda6 = new Venda(BigDecimal.valueOf(3400).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("12/2021") );
			Venda venda7 = new Venda(BigDecimal.valueOf(7700).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("01/2022") );
			Venda venda8 = new Venda(BigDecimal.valueOf(5000).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("02/2022") );
			Venda venda9 = new Venda(BigDecimal.valueOf(5900).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("03/2022") );
			Venda venda10 = new Venda(BigDecimal.valueOf(6500).setScale(2, BigDecimal.ROUND_DOWN), DataUtil.createDateMesAno("04/2022") );
			
			
			Funcionario funcionario1 = new Funcionario("Jorge Carvalho", cargo1, DataUtil.createDateMesAno("01/2018"));
			Funcionario funcionario2 = new Funcionario("Maria Souza", cargo1, DataUtil.createDateMesAno("12/2015"));
			Funcionario funcionario3 = new Funcionario("Ana Silva", cargo2, DataUtil.createDateMesAno("12/2021")).addVenda(venda1).addVenda(venda2).addVenda(venda3).addVenda(venda4).addVenda(venda5);
			Funcionario funcionario4 = new Funcionario("João Mendes", cargo2, DataUtil.createDateMesAno("12/2021")).addVenda(venda6).addVenda(venda7).addVenda(venda8).addVenda(venda9).addVenda(venda10);
			Funcionario funcionario5 = new Funcionario("Juliana Alves", cargo3, DataUtil.createDateMesAno("07/2017"));
			Funcionario funcionario6 = new Funcionario("Bento Albino", cargo3, DataUtil.createDateMesAno("03/2014"));
			
		
			System.out.println("funcionario3.getCargoDoFuncionario().getPorcentagemBeneficio() - " + funcionario3.getCargoDoFuncionario().getPorcentagemBeneficio());
			System.out.println("funcionario3.getCargoDoFuncionario().getSalario() - " + funcionario3.getCargoDoFuncionario().getSalario());
			System.out.println("funcionario3.getCargoDoFuncionario().getValorDeAbonoAnual() - " + funcionario3.getCargoDoFuncionario().getValorDeAbonoAnual());
			System.out.println("funcionario3.totalValorrecebidoPorVenda()) - " + funcionario3.totalValorrecebidoPorVenda()) ;
			System.out.println("funcionario3.totalDoSalario())"+ funcionario3.totalDoSalario());
			System.out.println("funcionario3.valorTotalAReceber())" + funcionario3.valorTotalAReceber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
	}	
	
}
