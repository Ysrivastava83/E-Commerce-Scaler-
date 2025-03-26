package com.example.productcatalogservice_march2025.repositories;

import com.example.productcatalogservice_march2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepositories extends JpaRepository<Product,Long>
{


    @Override
    Optional<Product> findById(Long aLong);

    Product save(Product product);
}
