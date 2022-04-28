package br.com.dao;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.exception.CargoException;
import br.com.model.Cargo;

/**
 * 
 * @author O Javoso
 *
 */

public class CargoDAO {

	private static List<Cargo> cargos;

	public CargoDAO() {
	}

	/**
	 * O M�todo utilizado para adicionar um novo cargo na lista de cargos que est�o
	 * em memoria.
	 * 
	 * O m�todo lan�a uma exception se o cargo que est� sendo adicionar j� estiver
	 * na lista ou quando o objeto cargo estiver nulo.
	 * 
	 * @param cargo
	 * @throws CargoException
	 */

	public static void addCargo(Cargo cargo) throws CargoException {
		if (isNull(cargos)) {
			cargos = new ArrayList<Cargo>();
		}

		if (cargos.contains(cargo) || isNull(cargo)) {
			throw new CargoException("O cargo " + cargo.getNomeCargo() + "J� foi adicionado na lista de cargos ou est� nulo");
		}

		cargos.add(cargo);
	}

	/**
	 * 
	 * O M�todo utilizado para exibir os cargos j� adicionados na listas que est� em
	 * memoria.
	 * 
	 * O m�todo ir� lan�ar uma exception se a lista estiver vazia ou nula.
	 * 
	 */

	public static void exibirCargos() {
		if (getCargos().isEmpty() || isNull(getCargos()))
			throw new CargoException("A lista de cargos est� vazia!");

		getCargos().forEach(System.out::println);
	}

	/**
	 * 
	 * Metodo utilizado para listar os cargos j� adicionados na listas que est� em
	 * memoria.
	 * 
	 * @return
	 */

	public static List<Cargo> getCargos() {
		if (!cargos.isEmpty()) {
			return cargos;
		}
		return Collections.emptyList();
	}

	/**
	 * 
	 * O Metodo utilizado para buscar um cargo pelo seu index na lista que est� em
	 * memoria.
	 * 
	 * @param index
	 * @return
	 */
	public static Cargo findByCargo(int index) {
		if (getCargos().isEmpty())
			throw new CargoException("A lista de cargos est� vazia!");

		return getCargos().get(index);
	}


	/**
	 * 
	 * O Metodo utilizado para setar uma lista de cargos na lista que est� em
	 * memoria.
	 * 
	 * @param cargos
	 */
	public static void setCargos(List<Cargo> cargos) {
		CargoDAO.cargos = cargos;
	}

}
