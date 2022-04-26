package br.com.service;

import java.io.Serializable;
import java.util.List;

import br.com.dao.CargoDAO;
import br.com.model.Cargo;

public class CargoService implements Serializable {

	private static final long serialVersionUID = 3890870251973431394L;

	public static List<Cargo> getCargos() {
		return CargoDAO.getCargos();
	}

	public void adicionarCargo(Cargo cargo) {
		CargoDAO.addCargo(cargo);
	}

	public void listarCargos() {
		CargoDAO.exibirCargos();
	}

	public Cargo findByCargo(int index) {
		return CargoDAO.findByCargo(index);
	}

}
