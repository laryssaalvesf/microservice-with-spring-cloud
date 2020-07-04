package br.com.microservice.services;

import br.com.microservice.entities.Product;
import br.com.microservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findByName(String name) {

        return productRepository.findByName(name);
    }

    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }




}
