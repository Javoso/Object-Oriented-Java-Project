package br.com.test;

import java.math.BigDecimal;

public class Cargo {

	private String nomeCargo;
	private BigDecimal salario;
	private double porcentagemBeneficio;
	private BigDecimal valorDeAbonoAnual;

	public Cargo(String nomeCargo, BigDecimal salario, double porcentagemBeneficio, BigDecimal valorDeAbonoAnual) {
		super();
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
		return porcentagemBeneficio;
	}

	public void setPorcentagemBeneficio(double porcentagemBeneficio) {
		this.porcentagemBeneficio = porcentagemBeneficio;
	}

}
