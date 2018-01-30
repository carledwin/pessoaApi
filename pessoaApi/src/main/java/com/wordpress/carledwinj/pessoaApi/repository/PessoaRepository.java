package com.wordpress.carledwinj.pessoaApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.wordpress.carledwinj.pessoaApi.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	Pessoa findByCpf(Long cpf);
}
