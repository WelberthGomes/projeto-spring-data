package br.com.welberth.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.welberth.spring.data.Prospectiva.FuncioarioProspectiva;
import br.com.welberth.spring.data.dto.FuncionarioDTO;
import br.com.welberth.spring.data.orm.Funcionario;
import br.com.welberth.spring.data.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
  
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public Page<Funcionario> buscarTodos() {
		Pageable pageable = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC,"nome"));
		 Page<Funcionario> funcionarios = this.funcionarioRepository.findAll(pageable);
		 System.out.println(funcionarios);
		 return funcionarios;
	}
	
	public Funcionario salvar(Funcionario funcionario) {
		return this.funcionarioRepository.save(funcionario);
	};
	
	public List<FuncioarioProspectiva> buscarSalarios() {
		return this.funcionarioRepository.buscarSalarios();
	}
	
	public List<FuncionarioDTO> getSalarioEIdadeDoFuncionario(){
		return this.funcionarioRepository.getSalarioEIdadeDoFuncionario();
	}
	
}
