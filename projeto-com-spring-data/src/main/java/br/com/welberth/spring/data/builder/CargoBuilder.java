package br.com.welberth.spring.data.builder;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

import br.com.welberth.spring.data.orm.Cargo;

public class CargoBuilder {
	private String descricao;
	
	public static CargoBuilder builder() {
		return new CargoBuilder();
	}
	
	public CargoBuilder descricao(String descricao) {
		this.descricao = descricao;
		return this;
	}
	
	public Cargo build() {
		return new Cargo(this.descricao);
	}
}
