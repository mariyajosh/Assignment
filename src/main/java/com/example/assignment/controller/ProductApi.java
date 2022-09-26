package com.example.assignment.controller;

import com.example.assignment.model.ProductResponse;
import com.example.assignment.model.QueryParams;
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

    /**
     * This API save the uploaded file data in data base
     * @param document Accept MultiPartFile(Csv formatted)
     * @return message includes total number of products added into database
     */

    @RequestMapping(path = "/products", method = POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    String addProducts(@RequestParam("file") MultipartFile document) {
        log.info("Request received for adding data");
        long numberOfProductsAdded = productsService.addProducts(document);
        return numberOfProductsAdded + " " + "Products added Successfully";
    }

    /**
     * API to fetch the product based on applied filters.
     * @param supplier filter based on given supplier name
     * @param productName filter based on given supplier name
     * @param expired  false returns unexpired products
     * @param stock    true returns product who has stock
     * @param page
     * @param size
     * @return List of Product and Total number of products available for applied filter

     */
    @RequestMapping(path = "/products", method = GET)
    ProductResponse getProducts(
            @RequestParam(required = false) String supplier,
            @RequestParam(required = false, value = "product-name") String productName,
            @RequestParam(required = false) Boolean expired,
            @RequestParam(required = false) Boolean stock,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        log.info("Request received for fetching the data");
        PageRequest pageRequest = PageRequest.of(page, size);
        QueryParams params = QueryParams.WrapParams(supplier, productName, expired, stock, pageRequest);
        return productsService.getProducts(params);
    }
}
