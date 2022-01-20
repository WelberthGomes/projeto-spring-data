package br.com.welberth.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.welberth.spring.data.Prospectiva.FuncioarioProspectiva;
import br.com.welberth.spring.data.dto.FuncionarioDTO;
import br.com.welberth.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario>{
	
	@Query(value = "SELECT f.salario FROM FUNCIONARIOS f ", nativeQuery = true)
	List<FuncioarioProspectiva> buscarSalarios();
	
	@Query(value = "SELECT f.salario, f.idade FROM funcionarios f", nativeQuery = true)
	List<FuncionarioDTO> getSalarioEIdadeDoFuncionario();

}
