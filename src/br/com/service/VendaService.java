package br.com.service;

import java.io.Serializable;
import java.util.List;

import br.com.dao.VendaDAO;
import br.com.model.Funcionario;
import br.com.model.Venda;

/**
 * 
 * @author O Javoso
 *
 */

public class VendaService implements Serializable {

	private static final long serialVersionUID = 3890870251973431394L;

	public List<Venda> getVendas() {
		return VendaDAO.getVendas();
	}

	public void adicionarVenda(Venda venda, Funcionario funcionario) {
		VendaDAO.addVenda(venda, funcionario);
	}

	public void listarVendas() {
		VendaDAO.exibirVendas();
	}

	public Venda findByVenda(int index) {
		return VendaDAO.findByVenda(index);
	}

}
