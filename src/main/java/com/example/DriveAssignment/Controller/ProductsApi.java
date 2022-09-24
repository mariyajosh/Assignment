package com.example.DriveAssignment.Controller;

import com.example.DriveAssignment.Model.Product;
import com.example.DriveAssignment.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProductsApi {
    @Autowired
    ProductsService productsService;

    @RequestMapping(path = "/products", method = POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    String addProducts(@RequestParam("file") MultipartFile document){
        productsService.addAllProducts(document);
        return "Products added successfully";
    }

    @RequestMapping(path = "/products" , method = GET)
    List<Product> getAllProducts(){
       return productsService.getAllProducts();
    }
}
