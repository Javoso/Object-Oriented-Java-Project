package br.com.dao;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.exception.FuncionarioException;
import br.com.model.Funcionario;

/**
 * 
 * @author O Javoso
 *
 */

public class FuncionarioDAO {

	private static List<Funcionario> funcionarios;

	public FuncionarioDAO() {
	}

	public static void addFuncionario(Funcionario funcionario) throws FuncionarioException {
		if (isNull(funcionarios)) {
			funcionarios = new ArrayList<Funcionario>();
		}

		if (funcionarios.contains(funcionario) && isNull(funcionario)) {
			throw new FuncionarioException("O funcionario " + funcionario.getNomeDoFuncionario()
					+ "Já foi adicionado na lista de funcionarios.");
		}

		funcionarios.add(funcionario);
		System.out.println("Funcionario adicionado com sucesso");
	}

	public static void exibirFuncionarios() {
		if (getFuncionarios().isEmpty())
			throw new FuncionarioException("A lista de funcionarios está vazia!");

		getFuncionarios().forEach(System.out::println);
	}

	public static List<Funcionario> getFuncionarios() {
		if (!funcionarios.isEmpty()) {
			return funcionarios;
		}
		return Collections.emptyList();
	}

	public static Funcionario findByFuncionario(int index) {
		if (getFuncionarios().isEmpty())
			throw new FuncionarioException("A lista de funcionarios está vazia!");

		return getFuncionarios().get(index);
	}

	public static Funcionario findByFuncionario(Funcionario funcionario) {
		if (getFuncionarios().isEmpty())
			throw new FuncionarioException("A lista de funcionarios está vazia!");

		return getFuncionarios().get(getFuncionarios().indexOf(funcionario));
	}

	public static Funcionario findByFuncionario(String nome) {
		if (getFuncionarios().isEmpty())
			throw new FuncionarioException("A lista de funcionarios está vazia!");

		return getFuncionarios().stream().filter(funcionario -> funcionario.verificarSeOsNomesSaoIguais(nome)).findAny()
				.orElseThrow(() -> new FuncionarioException("Descrição do funcionario não encontrado"));
	}

	public static void setFuncionarios(List<Funcionario> funcionarios) {
		FuncionarioDAO.funcionarios = funcionarios;
	}

}
