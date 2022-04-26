package br.com.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * Classe model Cargo com seu atributos e metódos.
 * 
 * @author O Javoso
 *
 */

public class Cargo implements Serializable {

	private static final long serialVersionUID = 6124196597928727345L;

	private String nomeCargo;
	private BigDecimal salario;
	private BigDecimal adicaoPorTempoDeServico;
	private float porcentagemBeneficio;

	public Cargo() {
	}

	/**
	 * Construtor com paramentros para inicializar o objeto.
	 * 
	 * @param nomeCargo
	 * @param salario
	 * @param adicaoPorTempoDeServico
	 * @param porcentagemBeneficio
	 */
	public Cargo(String nomeCargo, BigDecimal salario, BigDecimal adicaoPorTempoDeServico, float porcentagemBeneficio) {
		super();
		this.nomeCargo = nomeCargo;
		this.salario = salario;
		this.adicaoPorTempoDeServico = adicaoPorTempoDeServico;
		this.porcentagemBeneficio = porcentagemBeneficio;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public BigDecimal getSalario() {
		return salario.setScale(2, BigDecimal.ROUND_DOWN);
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public float getPorcentagemBeneficio() {
		return porcentagemBeneficio;
	}

	public void setPorcentagemBeneficio(float porcentagemBeneficio) {
		this.porcentagemBeneficio = porcentagemBeneficio;
	}

	public BigDecimal getAdicaoPorTempoDeServico() {
		return adicaoPorTempoDeServico.setScale(2, BigDecimal.ROUND_DOWN);
	}

	public void setAdicaoPorTempoDeServico(BigDecimal adicaoPorTempoDeServico) {
		this.adicaoPorTempoDeServico = adicaoPorTempoDeServico;
	}
	
	/**
	 * Metódo para retornar o valor do salario do funcionario.
	 * 
	 * @return
	 */
	public BigDecimal getValorDoSalario() {
		return salario;
	}

	/**
	 * 
	 * Metódo para retornar o valor total do benefecio do funcionario.
	 * 
	 * @return
	 */

	public BigDecimal getValorDoBeneficio() {
		return salario.multiply(new BigDecimal(porcentagemBeneficio)).setScale(2, BigDecimal.ROUND_DOWN);
	}

	/**
	 * Metódo para retornar o valor total do salario mais o benefecio do
	 * funcionario.
	 * 
	 * @return
	 */
	public BigDecimal getValorDoSalarioComBeneficio() {
		return salario.add(getValorDoBeneficio());
	}

	/**
	 * Metódo para calcular o valor que funcionario ira receber pelo seu tempo de
	 * serviço deste sua contratação até a data de sua demissão.
	 * 
	 * @param tempoDeServico
	 * @return
	 */
	public BigDecimal getValorTotalDeAdicionalPorTempodeServico(int tempoDeServico) {
		return adicaoPorTempoDeServico.multiply(new BigDecimal(tempoDeServico));
	}
	
	/**
	 * Metódo para calcular o valor total que um funcionario irá receber. 
	 * @return
	 */
	public BigDecimal valorTotalAReceber() {
		return getValorDoSalarioComBeneficio().add(adicaoPorTempoDeServico);
	}
	
	
	/**
	 * 
	 * Metódo para verificar se o valor do parametro é igual ao nme do cargo
	 * 
	 * @param nomePesquisa
	 * @return
	 */
	public boolean verificarSeOsNomesSaoIguais(String nomePesquisa) {
		return this.nomeCargo.equalsIgnoreCase(nomePesquisa);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCargo == null) ? 0 : nomeCargo.hashCode());
		result = prime * result + Float.floatToIntBits(porcentagemBeneficio);
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (nomeCargo == null) {
			if (other.nomeCargo != null)
				return false;
		} else if (!nomeCargo.equals(other.nomeCargo))
			return false;
		if (Float.floatToIntBits(porcentagemBeneficio) != Float.floatToIntBits(other.porcentagemBeneficio))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n Cargo { " 
				+ "\n	Cargo  : " + nomeCargo 
				+ ",\n	Salario : R$ " + salario 
				+ ",\n	Beneficio : R$ " + getValorDoBeneficio() 
				+ ",\n	Valor total de tempo de serviço: R$ " + adicaoPorTempoDeServico 
				+ "\n   }";
	}

}
