package com.example.assignment.service;

import com.example.assignment.model.Product;
import com.example.assignment.model.ProductResponse;
import com.example.assignment.model.QueryParams;
import com.example.assignment.repository.ProductRepository;
import com.example.assignment.util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public long addProducts(MultipartFile document) {
        try {
            log.info("reading file data through streams");
            InputStream inputStream = document.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            List<Product> products = mapToProducts(bufferedReader);
            Iterable<Product> result = productRepository.saveAll(products);
            return StreamSupport.stream(result.spliterator(), false).count();
        } catch (ParseException e) {
            log.error(e.getLocalizedMessage());
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
        return 0;
    }

    public ProductResponse getProducts(QueryParams params) {
        log.info("Invoking repository method");
        Page<Product> products = productRepository.getProducts(
                params.getSupplier(),
                params.getProductName(),
                params.getExpired(),
                params.getStock(),
                params.getPageRequest()
        );
        return new ProductResponse(products.getContent(), (int) products.getTotalElements());
    }

    private List<Product> mapToProducts(BufferedReader bufferedReader) throws IOException, ParseException {
        log.info("Mapping the data to product objects");
        boolean skipLine = true;
        String line;
        List<Product> products = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if (!skipLine) {
                String[] productDetails = line.split(",", 11);
                Product product = new Product();
                product.setCode(productDetails[0]);
                product.setName(productDetails[1]);
                product.setBatch(productDetails[2]);
                product.setStock(Integer.parseInt(productDetails[3]));
                product.setDeal(Integer.parseInt(productDetails[4]));
                product.setFree(Integer.parseInt(productDetails[5]));
                product.setMrp(Double.parseDouble(productDetails[6]));
                product.setRate(Double.parseDouble(productDetails[7]));
                product.setDate(Utility.formatStringToDate(productDetails[8]));
                product.setCompany(productDetails[9]);
                product.setSupplier(productDetails[10]);
                products.add(product);
            }
            skipLine = false;
        }
        return products;

    }

}
