package br.com.microservice.response;

import br.com.microservice.entities.Product;

import java.util.List;

public class ProductResponse {


    private List<Product> products;
    private int size;

    public ProductResponse(List<Product> products, int size) {
        this.products = products;
        this.size = size;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
