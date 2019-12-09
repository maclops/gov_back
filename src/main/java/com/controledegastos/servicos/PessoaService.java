package com.controledegastos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledegastos.entidade.Pessoa;
import com.controledegastos.excecao.RegraNegocioException;
import com.controledegastos.repositorio.PessoasRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoasRepository pessoaRepositorio;

	public List<Pessoa> buscarTodos() {
		return pessoaRepositorio.findAll();
	}

	public Optional<Pessoa> buscarPorId(Long codigo) {
		return pessoaRepositorio.findById(codigo);
	}

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepositorio.save(pessoa);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalvar = verificarPessoaExiste(codigo);
//		ValidarPessoaDuplicada(pessoa);
		BeanUtils.copyProperties(pessoa, pessoaSalvar, "codigo");
		return pessoaRepositorio.save(pessoaSalvar);
	}

	public void deletar(Long codigo) {
		verificarPessoaExiste(codigo);
		pessoaRepositorio.deleteById(codigo);
	}

	private Pessoa verificarPessoaExiste(Long codigo) {
		Optional<Pessoa> pessoa = buscarPorId(codigo);
		if (!pessoa.isPresent()) {
			throw new RegraNegocioException(String.format("A pessoa de código %s não foi encontrada", codigo));
		}
		return pessoa.get();
	}
	
/*	private void ValidarPessoaDuplicada(Pessoa pessoa) {
		
	}*/
}
