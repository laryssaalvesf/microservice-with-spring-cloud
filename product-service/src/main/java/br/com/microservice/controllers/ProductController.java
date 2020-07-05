package br.com.microservice.controllers;

import br.com.microservice.entities.Product;
import br.com.microservice.response.ProductResponse;
import br.com.microservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductResponse> getProductByName(@RequestParam String name){
        init();
        List<Product> products = productService.findByName(name);

        return ResponseEntity.ok(new ProductResponse(products, products.size()));
    }

    private void init() {
        if(productService.findAll().isEmpty()) {
            List<Product> products = createProducts();
            products.forEach(product -> productService.save(product));
        }
    }

    private List<Product> createProducts() {
        Product product1 = new Product();
        product1.setName("Glitter");
        product1.setPrice(2.50);
        product1.setExpirationDate(OffsetDateTime.now());

        Product product2 = new Product();
        product2.setName("HeadPhone");
        product2.setPrice(500);
        product2.setExpirationDate(OffsetDateTime.now().minusDays(30));

        return Arrays.asList(product1, product2);
    }

}
