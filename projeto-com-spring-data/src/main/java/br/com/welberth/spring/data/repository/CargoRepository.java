package br.com.welberth.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.welberth.spring.data.orm.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer>{

	Cargo findDistinctByDescricao(String descricao);

	List<Cargo> findByDataCadastro(LocalDate now);

	List<Cargo> findByDataCadastroGreaterThan(LocalDate now);

	List<Cargo> findByDataCadastroBetween(LocalDate of, LocalDate of2);
	
}
