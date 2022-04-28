package br.com.model;

import java.math.BigDecimal;

public class Cargo {

	private String nomeCargo;
	private BigDecimal salario;
	private double porcentagemBeneficio;
	private BigDecimal valorDeAbonoAnual;	

	public Cargo() {}

	public Cargo(String nomeCargo, BigDecimal salario, double porcentagemBeneficio, BigDecimal valorDeAbonoAnual) {
		this.nomeCargo = nomeCargo;
		this.salario = salario;
		this.porcentagemBeneficio = porcentagemBeneficio;
		this.valorDeAbonoAnual = valorDeAbonoAnual;
	}

	public BigDecimal getValorDeAbonoAnual() {
		return valorDeAbonoAnual;
	}

	public void setValorDeAbonoAnual(BigDecimal valorDeAbonoAnual) {
		this.valorDeAbonoAnual = valorDeAbonoAnual;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public double getPorcentagemBeneficio() {
		return porcentagemBeneficio / 100;
	}

	public void setPorcentagemBeneficio(double porcentagemBeneficio) {
		this.porcentagemBeneficio = porcentagemBeneficio;
	}

	/**
	 * Metódo para verificar se o funcionario tem beneficios.
	 * 
	 * @return
	 */
	
	public boolean temBeneficio() {
		return this.porcentagemBeneficio != 0;
	}
	
	
	/**
	 * Metódo para verificar se o funcionario tem beneficios.
	 * 
	 * @return
	 */
	public boolean naoTemBeneficio() {
		return !temBeneficio();
	}
	
	/**
	 * Metódo para verificar se o funcionario é um vendedor.
	 * 
	 * @return
	 */
	public boolean isVendendor() {
		return this.nomeCargo.equalsIgnoreCase("VENDEDOR");
	}
	/**
	 * Metódo para verificar se o funcionario é um secretário.
	 * 
	 * @return
	 */
	public boolean isSecretario() {
		return this.nomeCargo.equalsIgnoreCase("SECRETARIO");
	}
	/**
	 * Metódo para verificar se o funcionario tem gerente.
	 * 
	 * @return
	 */
	public boolean isGerente() {
		return this.nomeCargo.equalsIgnoreCase("GERENTE");
	}

	@Override
	public String toString() {
		return "Cargo [ NOME = " + nomeCargo + ", SALARIO = " + salario + ", PORCENTAGEM DO BENEFICIOS = "
				+ porcentagemBeneficio + ", VALOR DO ABONO ANUAL = " + valorDeAbonoAnual + "]";
	}
	
	

}
