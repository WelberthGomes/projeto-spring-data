package br.com.welberth.spring.data.especificacao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.welberth.spring.data.orm.Funcionario;
import br.com.welberth.spring.data.orm.Situacao;
import br.com.welberth.spring.data.repository.FuncionarioRepository;

@Service
public class RelatorioFuncionarioDinamico {
	
	private final FuncionarioRepository funcionarioRepository;

	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public List<Funcionario> buscarFuncionarioFiltrado(String nome,Short idade, BigDecimal salario, String cargo, Situacao situacao) {
		List<Funcionario> listFuncionario = 
				funcionarioRepository.findAll(
						FuncionarioSpecification.nome(nome)
						.and(FuncionarioSpecification.idade(idade))
						.and(FuncionarioSpecification.salario(salario))
						.and(FuncionarioSpecification.cargo(cargo))
						.and(FuncionarioSpecification.situacao(situacao))
						);
		
		return listFuncionario;
	}
	
	
	
}
