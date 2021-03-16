package com.id;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.id.dao.ProductRepository;
import com.id.entities.Product;

@SpringBootApplication
public class PatesserieAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatesserieAppApplication.class, args);
	}
	/*
	 * @Bean CommandLineRunner start(ProductRepository pr) { return args->{
	 * pr.save(new Product(null,"chbakia",15,"rien a dire","ahmed.png"));
	 * pr.save(new Product(null,"lfkas",16,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"Lfkas",15,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"sale",16,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"chbakia",15,"rien a dire" ,"ahmed.png")); pr.save(new
	 * Product(null,"lfkas",16,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"Lfkas",15,"rien a dire" ,"ahmed.png")); pr.save(new
	 * Product(null,"sale",16,"rien a dire" ,"ahmed.png")); pr.save(new
	 * Product(null,"lfkas",16,"rien a dire" ,"ahmed.png")); pr.save(new
	 * Product(null,"Lfkas",15,"rien a dire" ,"ahmed.png")); pr.save(new
	 * Product(null,"sale",16,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"chbakia",15,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"lfkas",16,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"Lfkas",15,"rien a dire","ahmed.png")); pr.save(new
	 * Product(null,"sale",16,"rien a dire","ahmed.png")); pr.findAll().forEach(c->{
	 * System.out.println(c.toString()); });
	 * 
	 * 
	 * }; }
	 */
}
