package com.example.DriveAssignment.Repository;

import com.example.DriveAssignment.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(
            value = "select * FROM Product where case when :supplier is null then true else supplier = :supplier end and case when :name is null then true else name ILIKE :name || '%' end and case when :expired is null then true else expire_date > CURRENT_DATE end",
            countQuery ="select count(*) FROM Product where case when :supplier is null then true else supplier = :supplier end and case when :name is null then true else name ILIKE :name || '%' end and case when :expired is null then true else expire_date > CURRENT_DATE end",
            nativeQuery = true)
    Page<Product> getProducts(@Param("supplier") String supplier, @Param("name") String name, @Param("expired") Boolean expired, Pageable pageable);
}
