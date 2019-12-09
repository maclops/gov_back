package com.controledegastos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledegastos.entidade.Lancamento;
import com.controledegastos.excecao.RegraNegocioException;
import com.controledegastos.repositorio.LancamentoRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepositorio;
	
	public List<Lancamento> buscarTodos() {
		return lancamentoRepositorio.findAll();
	}
	
	public Optional<Lancamento> buscarPorId(Long codigo) {
		return lancamentoRepositorio.findById(codigo);
	}
	
	public Lancamento salvar(Lancamento lancamento) {
		return lancamentoRepositorio.save(lancamento);
	}
	
	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvar = verificarLancamentoExiste(codigo);
		BeanUtils.copyProperties(lancamento, lancamentoSalvar, "codigo");
		return lancamentoRepositorio.save(lancamentoSalvar);
	}
	
	public void deletar(Long codigo) {
		verificarLancamentoExiste(codigo);
		lancamentoRepositorio.deleteById(codigo);
	}
	
	private Lancamento verificarLancamentoExiste(Long codigo) {
		Optional<Lancamento> lancamento = buscarPorId(codigo);
		if(!lancamento.isPresent()) {
			throw new RegraNegocioException(String.format("O lançamento de código %s não foi encontrado", codigo));
		}
		return lancamento.get();
	}
	
}
