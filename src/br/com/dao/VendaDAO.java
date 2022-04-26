package br.com.dao;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import br.com.exception.VendaException;
import br.com.model.Funcionario;
import br.com.model.Venda;

/**
 * 
 * @author O Javoso
 *
 */
public class VendaDAO {

	private static List<Venda> vendas;

	public VendaDAO() {
	}

	public static void addVenda(Venda venda) throws VendaException {
		if (isNull(vendas)) {
			vendas = new ArrayList<Venda>();
		}

		if (vendas.contains(venda) && isNull(venda)) {
			throw new VendaException("O venda " + venda + "Já foi adicionado na lista de vendas.");
		}

		vendas.add(venda);
		System.out.println("Venda adicionada com sucesso");
	}

	public static void exibirVendas() {
		if (getVendas().isEmpty())
			throw new VendaException("A lista de vendas está vazia!");

		getVendas().forEach(System.out::println);
	}

	public static List<Venda> getVendas() {
		if (!vendas.isEmpty()) {
			return vendas;
		}
		return Collections.emptyList();
	}

	public static Venda findByVenda(int index) {
		if (getVendas().isEmpty())
			throw new VendaException("A lista de vendas está vazia!");

		return getVendas().get(index);
	}

	public static List<Venda> vendasByFuncionario(Funcionario funcionario) {
		if (getVendas().isEmpty())
			throw new VendaException("A lista de vendas está vazia!");

		return getVendas().stream().filter(venda -> venda.verificarSeOsVendedoresSaoIguais(funcionario))
				.collect(Collectors.toList());
	}

	public static List<Venda> vendasByFuncionario(String nome) {
		if (getVendas().isEmpty())
			throw new VendaException("A lista de vendas está vazia!");

		return getVendas().stream().filter(venda -> venda.verificarSeOsVendedoresSaoIguais(nome))
				.collect(Collectors.toList());
	}

	public static void setVendas(List<Venda> vendas) {
		VendaDAO.vendas = vendas;
	}

}
