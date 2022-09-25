package com.example.assignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String name;
    private String batch;
    private int stock;
    private int deal;
    private int free;
    private double mrp;
    private double rate;
    @Column(name = "expire_date")
    private LocalDate date;
    private String company;
    private String supplier;
    public Product(){}

    public Product(int id, String code, String name, String batch, int stock, int deal, int free, double mrp, double rate, LocalDate date, String company, String supplier) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.batch = batch;
        this.stock = stock;
        this.deal = deal;
        this.free = free;
        this.mrp = mrp;
        this.rate = rate;
        this.date = date;
        this.company = company;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDeal() {
        return deal;
    }

    public void setDeal(int deal) {
        this.deal = deal;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", batch='" + batch + '\'' +
                ", stock=" + stock +
                ", deal=" + deal +
                ", free=" + free +
                ", mrp=" + mrp +
                ", rate=" + rate +
                ", date='" + date + '\'' +
                ", company='" + company + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Product)){
            return false;
        }
        Product product = (Product) obj;
        return this.id == product.id && this.batch.equalsIgnoreCase(product.batch) && this.code.equalsIgnoreCase(product.code)
                && this.company.equalsIgnoreCase(product.company) &&this.name.equalsIgnoreCase(product.name) && this.supplier.equalsIgnoreCase(product.supplier)
                && this.date == product.date && Integer.valueOf(this.stock).equals(Integer.valueOf(product.stock)) &&
                Integer.valueOf(this.deal).equals(Integer.valueOf(product.deal)) && Integer.valueOf(this.free).equals(Integer.valueOf(product.free))
                && Double.valueOf(this.mrp).equals(Double.valueOf(product.mrp)) && Double.valueOf(this.rate).equals(Double.valueOf(product.rate));

    }
}
