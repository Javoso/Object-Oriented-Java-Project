package br.com.main;

import br.com.mockers.AdicionarCargos;
import br.com.mockers.AdiconarFuncionarios;

public class Principal {
	
	public static void main(String[] args) {
		AdicionarCargos ac = new AdicionarCargos();
		
		ac.adicionarCargos();
		ac.exibirDado();
		
		AdiconarFuncionarios af = new AdiconarFuncionarios();
		
		af.adicionarFuncionarios();
		af.exibirDado();
	}
}
