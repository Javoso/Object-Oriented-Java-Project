package br.com.service;

import java.io.Serializable;
import java.util.List;

import br.com.dao.VendaDAO;
import br.com.model.Funcionario;
import br.com.model.Venda;

public class VendaService implements Serializable {

	private static final long serialVersionUID = 3890870251973431394L;

	public static List<Venda> getVendas() {
		return VendaDAO.getVendas();
	}

	public void adicionarVenda(Venda venda) {
		VendaDAO.addVenda(venda);
	}

	public void listarVendas() {
		VendaDAO.exibirVendas();
	}

	public Venda findByVenda(int index) {
		return VendaDAO.findByVenda(index);
	}

	public List<Venda> vendaByFuncionario(Funcionario funcionario) {
		return VendaDAO.vendasByFuncionario(funcionario);
	}

	public List<Venda> vendaByVendedor(String nome) {
		return VendaDAO.vendasByFuncionario(nome);
	}

}
