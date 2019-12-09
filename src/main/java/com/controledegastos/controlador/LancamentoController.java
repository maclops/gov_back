package com.controledegastos.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.controledegastos.entidade.Lancamento;
import com.controledegastos.servicos.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoServico;
	
	@GetMapping
	public List<Lancamento> buscarTodos() {
		return lancamentoServico.buscarTodos();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPorId(@PathVariable("codigo") Long codigo) {
		Optional<Lancamento> lancamento = lancamentoServico.buscarPorId(codigo);
		return lancamento.isPresent() ? ResponseEntity.ok(lancamento.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> salvar (@Valid @RequestBody Lancamento lancamento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoServico.salvar(lancamento));
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Lancamento> atualizar(@PathVariable("codigo") Long codigo, @Valid @RequestBody Lancamento lancamento) {
		return ResponseEntity.ok(lancamentoServico.atualizar(codigo, lancamento));
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable("codigo") Long codigo) {
		lancamentoServico.deletar(codigo);
	}
	
}
