package com.example.assignment.repository;

import com.example.assignment.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest()
public class ProductRepositoryIntegrationTest {
    @Autowired

    private ProductRepository productRepository;
    Product product = new Product(1, "RENT", "RENT", "", 24, 0, 0, 0.0, 0.0, null, "RENT", "SARADA PHARMACY");
    List<Product> productList = new ArrayList<>();
    @Test
    public void saveProducts(){
        productList.add(product);
        productRepository.saveAll(productList);
        productRepository.findById(1).get();
        Assertions.assertEquals(productRepository.findById(1).get(), product);
    }

    @Test
    public void getProducts(){
        productList.add(product);
        Page<Product> page =  productRepository.getProducts(null, null, null, null, null);
        Assertions.assertEquals(page.getTotalElements(), 1);
        Assertions.assertEquals(page.getContent(), productList);
    }
}
