package com.example.assignment.model;

import org.springframework.data.domain.PageRequest;

public class QueryParams {
    private String supplier;
    private String productName;
    private Boolean expired;
    private Boolean stock;
    private PageRequest pageRequest;

    public String getSupplier() {
        return supplier;
    }

    public String getProductName() {
        return productName;
    }

    public Boolean getExpired() {
        return expired;
    }

    public Boolean getStock() {
        return stock;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public QueryParams(String supplier, String productName, Boolean expired, Boolean stock, PageRequest pageRequest) {
        this.supplier = supplier;
        this.productName = productName;
        this.expired = expired;
        this.stock = stock;
        this.pageRequest = pageRequest;
    }

    public static QueryParams WrapParams(String supplier, String productName, Boolean expired, Boolean stock, PageRequest pageRequest) {
        return new QueryParams(supplier, productName, expired, stock, pageRequest);
    }

}




