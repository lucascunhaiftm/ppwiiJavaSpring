package br.edu.iftm.meuAppSpringJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.meuAppSpringJava.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}