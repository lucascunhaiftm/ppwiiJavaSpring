package br.edu.iftm.meuAppSpringJava.service;

import java.util.List;

import br.edu.iftm.meuAppSpringJava.model.Product;

public interface ProductService {

    List <Product> getAllProducts();
    void saveProduct(Product product);
    Product getProductById(long id);
    void deleteProductById(long id);
}