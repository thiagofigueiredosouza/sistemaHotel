package com.trabalhopoo.hotelapp;

import java.time.LocalDate;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.trabalhopoo.hotelapp.rh.dominio.Cliente;
import com.trabalhopoo.hotelapp.rh.dominio.ClienteRepositorio;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio clienteRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente("Joao");
		c1.setDataEntrada(LocalDate.of(2022, 8, 14));
		c1.setQuarto("1");
		c1.setCpf("75904387075");
		c1.setDataSaida(LocalDate.of(2022, 8, 17));
		c1.setPagamento("Cartão de Crédito");
		
		Cliente c2 = new Cliente("Maria");
		c2.setDataEntrada(LocalDate.of(2022, 8, 15));
		c2.setQuarto("2");
		c2.setCpf("47995388020");
		c2.setDataSaida(LocalDate.of(2022, 8, 21));
		c2.setPagamento("Dinheiro");
		
		
		clienteRepo.save(c1);
		clienteRepo.save(c2);
	}
}