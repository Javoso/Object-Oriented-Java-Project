package br.com.dao;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.exception.CargoException;
import br.com.model.Cargo;

public class CargoDAO {

	private static List<Cargo> cargos;

	public CargoDAO() {
	}

	public static void addCargo(Cargo cargo) throws CargoException {
		if (isNull(cargos)) {
			cargos = new ArrayList<Cargo>();
		}

		if (cargos.contains(cargo) && isNull(cargo)) {
			throw new CargoException("O cargo " + cargo.getNomeCargo() + "Já foi adicionado na lista de cargos.");
		}

		cargos.add(cargo);
		System.out.println("Cargo adicionado com sucesso");
	}

	public static void exibirCargos() {
		if (getCargos().isEmpty())
			throw new CargoException("A lista de cargos está vazia!");

		getCargos().forEach(System.out::println);
	}

	public static List<Cargo> getCargos() {
		if (!cargos.isEmpty()) {
			return cargos;
		}
		return Collections.emptyList();
	}

	public static Cargo findByCargo(int index) {
		if (getCargos().isEmpty())
			throw new CargoException("A lista de cargos está vazia!");

		return getCargos().get(index);
	}

	public static Cargo findByCargo(String nome) {
		if (getCargos().isEmpty())
			throw new CargoException("A lista de cargos está vazia!");

		return getCargos().stream().filter(cargo -> cargo.verificarSeOsNomesSaoIguais(nome)).findAny()
				.orElseThrow(() -> new CargoException("Descrição do cargo não encontrado"));
	}

	public static void setCargos(List<Cargo> cargos) {
		CargoDAO.cargos = cargos;
	}

}
