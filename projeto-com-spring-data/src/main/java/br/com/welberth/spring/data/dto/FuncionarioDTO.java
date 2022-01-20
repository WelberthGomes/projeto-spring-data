package br.com.welberth.spring.data.dto;

import java.math.BigDecimal;

public class FuncionarioDTO {
	private BigDecimal salario;
	private Integer idade;

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public FuncionarioDTO(BigDecimal salario, Integer idade) {
		this.salario = salario;
		this.idade = idade;
	}
	
	
	
}
