package com.example.assignment.model;

import java.util.List;

public class ProductResponse {
   List<Product> products;
   int totalRecords;

    public ProductResponse(List<Product> products, int totalRecords) {
        this.products = products;
        this.totalRecords = totalRecords;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
