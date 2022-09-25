package com.example.DriveAssignment.service;


import com.example.DriveAssignment.Model.Product;
import com.example.DriveAssignment.Repository.ProductRepository;
import com.example.DriveAssignment.Service.ProductsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductsServiceTest {

    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductsService productsService;

    Product product = new Product(0, "RENT", "RENT", "", 24, 0, 0, 0.0, 0.0, null, "RENT", "SARADA PHARMACY");
    List<Product> productList = new ArrayList<>();
    @Test
    public void ShouldParseGivenDataAndCallSaveAllMethodToSaveData() {

        productList.add(product);
        Mockito.when(productRepository.saveAll(productList)).thenReturn(productList);
        productsService.addAllProducts(convertCsvToMultipartFile());
        Mockito.verify(productRepository, Mockito.times(1)).saveAll(productList);
    }

    @Test
    public void ShouldCallRepositoryMethodToGetDataWithParams(){
        Page<Product> page = new PageImpl<>(productList);
        Mockito.when(productRepository.getSuppliers("Atlassian", "software", true, null)).thenReturn(page);
        productsService.getAllProducts("Atlassian", "software", true, null);
        Mockito.verify(productRepository, Mockito.times(1)).getSuppliers("Atlassian", "software", true, null);
    }

    @Test
    public void ShouldCallRepositoryMethodToGetDataWithEmptyParams(){
        Page<Product> page = new PageImpl<>(productList);
        Mockito.when(productRepository.getSuppliers(null, null, null, null)).thenReturn(page);
        productsService.getAllProducts(null, null, null, null);
        Mockito.verify(productRepository, Mockito.times(1)).getSuppliers(null, null, null, null);
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
