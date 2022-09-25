package com.example.assignment.controller;

import com.example.assignment.model.ProductResponse;
import com.example.assignment.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProductApi {
    @Autowired
    private ProductsService productsService;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/products", method = POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    String addProducts(@RequestParam("file") MultipartFile document) {
        log.info("Request received for adding data");
        long numberOfProductsAdded = productsService.addProducts(document);
        return numberOfProductsAdded + " " + "Products added Successfully";
    }

    @RequestMapping(path = "/products", method = GET)
    ProductResponse getProducts(
            @RequestParam(required = false) String supplier,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Boolean expired,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        log.info("Request received for fetching the data");
        PageRequest pageRequest = PageRequest.of(page, size);
        return productsService.getProducts(supplier, productName, expired, pageRequest);
    }
}
