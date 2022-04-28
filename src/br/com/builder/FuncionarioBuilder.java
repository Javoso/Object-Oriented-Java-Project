package br.com.builder;

import java.util.Date;

import br.com.model.Cargo;
import br.com.model.Funcionario;
import br.com.model.Venda;

/**
 * Classe FuncionarioBuilder é utilizado para a crição de um objeto com muitas
 * opções possíveis de inicialização.
 * 
 * @author O Javoso
 *
 */
public class FuncionarioBuilder {

	private Funcionario funcionario;

	public FuncionarioBuilder() {
		funcionario = new Funcionario();
	}

	/**
	 * 
	 * Adiciona um nome para o funcionario e retorna o objeto da classe
	 * FuncionarioBuilder
	 * 
	 * @param nome
	 * @return
	 */
	public FuncionarioBuilder funcionarioComNome(String nome) {
		funcionario.setNomeDoFuncionario(nome);
		return this;
	}

	/**
	 * 
	 * Adiciona um cargo para o funcionario e retorna o objeto da classe
	 * FuncionarioBuilder
	 * 
	 * @param cargoDoFuncionario
	 * @return
	 */

	public FuncionarioBuilder funcionarioComCargo(Cargo cargoDoFuncionario) {
		funcionario.setCargoDoFuncionario(cargoDoFuncionario);
		return this;
	}

	/**
	 * 
	 * Adiciona a data de contração para o funcionario e retorna o objeto da classe
	 * FuncionarioBuilder
	 * 
	 * @param dataDaContratacao
	 * @return
	 */

	public FuncionarioBuilder funcionarioComDataDeContratacao(Date dataDaContratacao) {
		funcionario.setDataDaContratacao(dataDaContratacao);
		return this;
	}
	
	/**
	 * 
	 * Adiciona uma venda para o funcionario e retorna o objeto da classe
	 * FuncionarioBuilder
	 * 
	 * @param dataDaContratacao
	 * @return
	 */

	public FuncionarioBuilder funcionarioComVenda(Venda venda) {
		funcionario.addVenda(venda);
		return this;
	}

	/**
	 * 
	 * Retorna o objeto criado da classe Funcionario com os valor que foram setados
	 * nele.
	 * 
	 * @return
	 */
	public Funcionario getNovoFuncionario() {
		return funcionario;
	}

}
