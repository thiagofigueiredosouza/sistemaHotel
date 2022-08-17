package com.trabalhopoo.hotelapp;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.trabalhopoo.hotelapp.rh.dominio.Pessoa;
import com.trabalhopoo.hotelapp.rh.dominio.PessoaRepositorio;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

	@Autowired
	private PessoaRepositorio pessoaRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Pessoa p1 = new Pessoa("Joao");
		p1.setDataNascimento(LocalDate.of(1990, 4, 1));
		p1.setQuarto("1");
		p1.setCpf("10518516962");
		
		Pessoa p2 = new Pessoa("Maria");
		p2.setDataNascimento(LocalDate.of(1900, 1, 1));
		p2.setQuarto("2");
		p2.setCpf("10518516962");
		
		
		pessoaRepo.save(p1);
		pessoaRepo.save(p2);
	}
}