package com.example.DriveAssignment.Service;

import com.example.DriveAssignment.Model.Product;
import com.example.DriveAssignment.Model.ProductResponse;
import com.example.DriveAssignment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    @Autowired
    private ProductRepository productRepository;

    public void addAllProducts(MultipartFile document){
             try {
                InputStream inputStream = document.getInputStream();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                 List<Product> products = mapToProducts(bufferedReader);
                 productRepository.saveAll(products);

            } catch (IOException e) {
                 System.out.println("exception");
            }
             catch(Exception e){
              System.out.println(e.getLocalizedMessage());
        }
    }
    public ProductResponse getAllProducts(String suppliers, String name, PageRequest pageRequest){
     Page<Product> products = productRepository.getSuppliers(suppliers, name, pageRequest);
     return new ProductResponse(products.getContent(), (int)products.getTotalElements());
    }

    private List<Product> mapToProducts(BufferedReader bufferedReader) throws IOException {
        boolean skipLine = true;
        String line;
        List<Product> products = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            if(!skipLine) {
                String[] r = line.split(",",11);
                Product product = new Product();
                product.setCode(r[0]);
                product.setName(r[1]);
                product.setBatch(r[2]);
                product.setStock(Integer.parseInt(r[3]));
                product.setDeal(Integer.parseInt(r[4]));
                product.setFree(Integer.parseInt(r[5]));
                product.setMrp(Double.parseDouble(r[6]));
                product.setRate(Double.parseDouble(r[7]));
                product.setDate(r[8]);
                product.setCompany(r[9]);
                product.setSupplier(r[10]);
                products.add(product);
            }
            skipLine = false;
        }
        return products;

    }

}
