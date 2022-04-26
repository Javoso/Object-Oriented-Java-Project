package br.com.mockers;

import java.math.BigDecimal;
import java.util.List;

import br.com.builder.VendaBuilder;
import br.com.model.Funcionario;
import br.com.model.Venda;
import br.com.service.FuncionarioService;
import br.com.service.VendaService;
import br.com.util.DataUtil;

/**
 * 
 * @author O Javoso
 *
 */

public class AdicionarVendas {

	private VendaService service = new VendaService();

	private FuncionarioService funcionarioService = new FuncionarioService();

	public void adicionarVendas() {

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("01/2022"))
						.vendaComValor(new BigDecimal(5200)).getNovoVenda(),
				funcionarioService.findByFuncionario("Ana Silva"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("01/2022"))
						.vendaComValor(new BigDecimal(4000)).getNovoVenda(),
				funcionarioService.findByFuncionario("Ana Silva"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("02/2022"))
						.vendaComValor(new BigDecimal(4200)).getNovoVenda(),
				funcionarioService.findByFuncionario("Ana Silva"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("03/2022"))
						.vendaComValor(new BigDecimal(5850)).getNovoVenda(),
				funcionarioService.findByFuncionario("Ana Silva"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("04/2022"))
						.vendaComValor(new BigDecimal(7000)).getNovoVenda(),
				funcionarioService.findByFuncionario("Ana Silva"));

		// ===========================================================================================

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("12/2021"))
						.vendaComValor(new BigDecimal(3400)).getNovoVenda(),
				funcionarioService.findByFuncionario("João Mendes"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("01/2022"))
						.vendaComValor(new BigDecimal(7700)).getNovoVenda(),
				funcionarioService.findByFuncionario("João Mendes"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("02/2022"))
						.vendaComValor(new BigDecimal(5000)).getNovoVenda(),
				funcionarioService.findByFuncionario("João Mendes"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("03/2022"))
						.vendaComValor(new BigDecimal(5900)).getNovoVenda(),
				funcionarioService.findByFuncionario("João Mendes"));

		service.adicionarVenda(
				new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("04/2022"))
						.vendaComValor(new BigDecimal(6500)).getNovoVenda(),
				funcionarioService.findByFuncionario("João Mendes"));

	}

	public void exibirDado() {
		service.listarVendas();
	}

	public List<Venda> vendasPorFuncionario(Funcionario vendedor) {
		return funcionarioService.findByFuncionario(vendedor).getVendas();
	}

	public List<Venda> vendasPorVendedor(String vendedor) {
		return funcionarioService.findByFuncionario(vendedor).getVendas();
	}

}
