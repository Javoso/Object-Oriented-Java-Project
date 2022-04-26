package br.com.service;

import java.util.List;

import br.com.dao.FuncionarioDAO;
import br.com.model.Funcionario;

public class FuncionarioService {
	
	public static List<Funcionario> getFuncionarios() {
		return FuncionarioDAO.getFuncionarios();
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		FuncionarioDAO.addFuncionario(funcionario);
	}

	public void listarFuncionarios() {
		FuncionarioDAO.exibirFuncionarios();
	}
}