package br.com.welberth.spring.data.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.welberth.spring.data.orm.Cargo;
import br.com.welberth.spring.data.repository.CargoRepository;

@Service
public class CargoService {

	private final CargoRepository repository;
	
	@Autowired
	public CargoService(CargoRepository repository) {
		super();
		this.repository = repository;
	}

	public Cargo buscaPorDescricao(String descricao){
		return repository.findDistinctByDescricao(descricao);
	};
	
	public List<Cargo> buscaPorData(String descricao){
		return repository.findByDataCadastro(LocalDate.now());
	};
}
