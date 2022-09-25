package com.example.assignment.controller;

import com.example.assignment.model.Product;
import com.example.assignment.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductApiIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getData() throws Exception {
        Product product = new Product(1, "RENT", "RENT", "", 24, 0, 0, 0.0, 0.0, null, "RENT", "SARADA PHARMACY");
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productRepository.saveAll(productList);
        mockMvc.perform(get("/products")).andExpect(status().is2xxSuccessful()).andExpect(content().string("{\"products\":[{\"id\":1,\"code\":\"RENT\",\"name\":\"RENT\",\"batch\":\"\",\"stock\":24,\"deal\":0,\"free\":0,\"mrp\":0.0,\"rate\":0.0,\"date\":null,\"company\":\"RENT\",\"supplier\":\"SARADA PHARMACY\"}],\"totalRecords\":1}"));
    }
    private MultipartFile convertCsvToMultipartFile() {
        try {
            MultipartFile multipartFile = new MockMultipartFile("testData.csv", new FileInputStream(new File("src/test/resources/testData.csv")));
            return multipartFile;
        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }
        return null;
    }
}
