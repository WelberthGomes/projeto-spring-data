package br.com.welberth.spring.data.orm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "idade")
	private Short idade;
	
	@Column(name = "matricula")
	private String matricula;
	
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	@Column(name = "salario")
	private BigDecimal salario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Cargo cargo;
	
	public Funcionario() {}
	
	public Funcionario(String nome, Short idade, String matricula, Situacao situacao, BigDecimal salario, Cargo cargo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.situacao = situacao;
		this.salario = salario;
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Short getIdade() {
		return idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public Cargo getCargo() {
		return cargo;
	}


	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", idade=" + idade + ", matricula=" + matricula
				+ ", situacao=" + situacao + ", salario=" + salario + ", cargo=" + cargo.getDescricao() + "]";
	}
	
	
	
	
}

