package br.com.welberth.spring.data.especificacao;

import java.math.BigDecimal;

import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import br.com.welberth.spring.data.orm.Funcionario;
import br.com.welberth.spring.data.orm.Situacao;

public class FuncionarioSpecification {
	
	public static Specification<Funcionario> nome(String nome ){
		return (root, query,criteriaBuilder) -> 
		criteriaBuilder.like(root.get("nome"), Strings.EMPTY.concat("%").concat(nome).concat("%"));
	}
	
	public static Specification<Funcionario> salario(BigDecimal salario ){
		return (root, query,criteriaBuilder) -> 
		criteriaBuilder.greaterThanOrEqualTo(root.get("salario"), salario);
	}
	
	public static Specification<Funcionario> idade(Short idade ){
		return (root, query,criteriaBuilder) -> 
		criteriaBuilder.equal(root.get("idade"), idade);
	}
	
	public static Specification<Funcionario> situacao(Situacao situacao ){
		return (root, query,criteriaBuilder) -> 
		criteriaBuilder.equal(root.get("situacao"), situacao);
	}
	
	public static Specification<Funcionario> cargo(String cargo ){
		return (root, query,criteriaBuilder) -> 
		criteriaBuilder.like(root.get("cargo").get("descricao"), "%"+cargo+"%");
	}
	

}
