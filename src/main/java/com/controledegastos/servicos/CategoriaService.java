package com.controledegastos.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledegastos.entidade.Categoria;
import com.controledegastos.excecao.RegraNegocioException;
import com.controledegastos.repositorio.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepositorio;

	public List<Categoria> buscarTodos() {
		return categoriaRepositorio.findAll();
	}

	public Optional<Categoria> buscarPorId(Long codigo) {
		return categoriaRepositorio.findById(codigo);
	}
	
	// método para filtrar busca pela query do front
	public List<Categoria> filtrarCategoriaPorTexto(String texto) {
		return categoriaRepositorio.findByNomePorTexto(texto);
	}

	public Categoria salvar(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}

	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalvar = verificarCategoriaExiste(codigo);
		BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");
		return categoriaRepositorio.save(categoriaSalvar);
	}

	public void deletar(Long codigo) {
		verificarCategoriaExiste(codigo);
		categoriaRepositorio.deleteById(codigo);
	}

	private Categoria verificarCategoriaExiste(Long codigo) {
		Optional<Categoria> categoria = buscarPorId(codigo);
		if (!categoria.isPresent()) {
			throw new RegraNegocioException(String.format("A categoria de código %s não foi encontrada!", codigo));
		}
		return categoria.get();
	}
}
