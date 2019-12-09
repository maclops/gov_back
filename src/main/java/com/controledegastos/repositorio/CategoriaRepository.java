package com.controledegastos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controledegastos.entidade.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	// select de busca do front para o back
	@Query("select c from Categoria c where c.nome like %:texto%")
	List<Categoria> findByNomePorTexto(@Param("texto") String texto);
	
	/*
	@Query("select c from Categoria c where c.nome =:nome")
	Categoria buscarPeloNome(@Param("nome") String nome);
	 */
}
