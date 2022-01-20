package br.com.welberth.spring.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.welberth.spring.data.builder.CargoBuilder;
import br.com.welberth.spring.data.orm.Cargo;
import br.com.welberth.spring.data.repository.CargoRepository;

public class CargoTest {
	
	
	CargoRepository repository;
	
	@Autowired
	public CargoTest(CargoRepository repository) {
		this.repository = repository;
	}
	
	@Test
	public void salvar() {
		Cargo cargo = CargoBuilder.builder().descricao("Desenvolvedor").build();
		repository.save(cargo);
	}

}
