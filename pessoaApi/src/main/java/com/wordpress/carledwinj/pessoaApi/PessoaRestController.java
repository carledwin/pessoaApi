package com.wordpress.carledwinj.pessoaApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.carledwinj.pessoaApi.model.Pessoa;
import com.wordpress.carledwinj.pessoaApi.repository.PessoaRepository;

@RestController
@RequestMapping(value="/pessoaApi")
public class PessoaRestController {

	@Autowired
	private PessoaRepository repository;
	
	@RequestMapping(value="/pessoa/{cpf}", method=RequestMethod.GET)
	public ResponseEntity<Pessoa> getPessoa(@PathVariable("cpf") long cpf){
		return new ResponseEntity<Pessoa>(repository.findByCpf(cpf), HttpStatus.OK);
	}
	
	@RequestMapping(value="/pessoa", method=RequestMethod.POST)
	public ResponseEntity<Pessoa> postPessoa(@RequestBody Pessoa pessoa){
		return new ResponseEntity<Pessoa>(repository.save(pessoa), HttpStatus.CREATED);	
	}
	
	@RequestMapping(value="/pessoas", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Pessoa>> getTodasPessoas(){
		
		Iterable<Pessoa> pessoas = repository.findAll();
		
		return new ResponseEntity<Iterable<Pessoa>>(pessoas, HttpStatus.OK);
	}
}
