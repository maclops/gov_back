package com.controledegastos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controledegastos.entidade.Pessoa;

@Repository
public interface PessoasRepository extends JpaRepository<Pessoa, Long> {

}
