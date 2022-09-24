package com.example.DriveAssignment.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    int id;
    String code;
    String name;
    String batch;
    int stock;
    int deal;
    int free;
    double mrp;
    double rate;
    String date;
    String company;
    String Supplier;
    public Product(){}

    public Product(int id, String code, String name, String batch, int stock, int deal, int free, double mrp, double rate, String date, String company, String supplier) {
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
        Supplier = supplier;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String supplier) {
        Supplier = supplier;
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
                ", Supplier='" + Supplier + '\'' +
                '}';
    }
}
