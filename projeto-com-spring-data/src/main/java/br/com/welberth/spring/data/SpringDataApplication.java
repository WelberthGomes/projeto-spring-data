package br.com.welberth.spring.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import br.com.welberth.spring.data.Prospectiva.FuncioarioProspectiva;
import br.com.welberth.spring.data.dto.FuncionarioDTO;
import br.com.welberth.spring.data.especificacao.RelatorioFuncionarioDinamico;
import br.com.welberth.spring.data.orm.Cargo;
import br.com.welberth.spring.data.orm.Funcionario;
import br.com.welberth.spring.data.orm.Situacao;
import br.com.welberth.spring.data.repository.CargoRepository;
import br.com.welberth.spring.data.service.FuncionarioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	public final CargoRepository cargoRepository;
	
	@Autowired
	public FuncionarioService funcionarioService;
	
	@Autowired
	RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	
	@Autowired
	public SpringDataApplication(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
//		cargoRepository.save(CargoBuilder.builder().descricao("DBA").build());
//		cargoRepository.save(CargoBuilder.builder().descricao("Analista de Requisitos").build());
		
//		List<Cargo> cargos = cargoRepository.findByDataCadastro(LocalDate.now());
		
//		List<Cargo> cargos = cargoRepository.findByDataCadastroGreaterThan(LocalDate.of(2021, 8, 22));
		
		List<Cargo> cargos = cargoRepository.findByDataCadastroBetween(LocalDate.of(2021, 8, 24), LocalDate.of(2021, 8, 24));
		
		for (Cargo cargo : cargos) {
			System.out.println(cargo);
		}
		
		Cargo cargo = cargoRepository.findById(9).get();
		
//		Funcionario funcionario1 = new Funcionario("Welberth", Short.valueOf("32"), "M345644", Situacao.ATIVO, new BigDecimal(15000), cargo);
//		Funcionario funcionario2 = new Funcionario("Andre", Short.valueOf("32"), "M345644", Situacao.ATIVO, new BigDecimal(15000), cargo);
//		Funcionario funcionario3 = new Funcionario("Pedro", Short.valueOf("32"), "M345644", Situacao.ATIVO, new BigDecimal(15000), cargo);
//		Funcionario funcionario4 = new Funcionario("João", Short.valueOf("32"), "M345644", Situacao.ATIVO, new BigDecimal(15000),cargo);
		
//		this.funcionarioService.salvar(funcionario1);
//		this.funcionarioService.salvar(funcionario2);
//		this.funcionarioService.salvar(funcionario3);
//		this.funcionarioService.salvar(funcionario4);
		
		System.out.println();
		
		Page<Funcionario> funcionarios = funcionarioService.buscarTodos();
		System.out.println(funcionarios);
		System.out.println(funcionarios.getNumber());
		System.out.println(funcionarios.getSize());
		System.out.println(funcionarios.getTotalElements());
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
		
		List<FuncioarioProspectiva> listFuncioarioProspectiva = this.funcionarioService.buscarSalarios();
		for (FuncioarioProspectiva funcionario : listFuncioarioProspectiva) {
			System.out.println(funcionario.getSalario());
		}
		
		List<Funcionario> listaDeFuncionarios = 
				this.relatorioFuncionarioDinamico.buscarFuncionarioFiltrado("o", Short.valueOf("32"), BigDecimal.valueOf(15000),"DBA", Situacao.ATIVO);
		
		for (Funcionario funcionario : listaDeFuncionarios) {
			System.out.println(funcionario.getNome());
		}
	}

}
