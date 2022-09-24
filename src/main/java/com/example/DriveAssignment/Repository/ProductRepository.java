package com.example.DriveAssignment.Repository;

import com.example.DriveAssignment.Model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
