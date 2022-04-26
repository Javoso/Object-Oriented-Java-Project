package br.com.mockers;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

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

		service.adicionarVenda(new VendaBuilder()
				.vendaComDataDeCompra(DataUtil.createDateMesAno(JOptionPane.showInputDialog("Adicione data da venda?")))
				.vendaComVendedor(funcionarioService.findByFuncionario("Ana Silva")).vendaComValor(new BigDecimal(5200))
				.getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("01/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("Ana Silva")).vendaComValor(new BigDecimal(4000))
				.getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("02/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("Ana Silva")).vendaComValor(new BigDecimal(4200))
				.getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("03/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("Ana Silva")).vendaComValor(new BigDecimal(5850))
				.getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("04/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("Ana Silva")).vendaComValor(new BigDecimal(7000))
				.getNovoVenda());

		// ===========================================================================================

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("12/2021"))
				.vendaComVendedor(funcionarioService.findByFuncionario("João Mendes"))
				.vendaComValor(new BigDecimal(3400)).getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("01/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("João Mendes"))
				.vendaComValor(new BigDecimal(7700)).getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("02/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("João Mendes"))
				.vendaComValor(new BigDecimal(5000)).getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("03/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("João Mendes"))
				.vendaComValor(new BigDecimal(5900)).getNovoVenda());

		service.adicionarVenda(new VendaBuilder().vendaComDataDeCompra(DataUtil.createDateMesAno("04/2022"))
				.vendaComVendedor(funcionarioService.findByFuncionario("João Mendes"))
				.vendaComValor(new BigDecimal(6500)).getNovoVenda());

	}

	public void exibirDado() {
		service.listarVendas();
	}

	public List<Venda> vendasPorFuncionario(Funcionario vendedor) {
		return service.vendaByFuncionario(vendedor);
	}

	public List<Venda> vendasPorVendedor(String vendedor) {
		return service.vendaByVendedor(vendedor);
	}

}
