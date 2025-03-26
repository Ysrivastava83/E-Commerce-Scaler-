package com.example.productcatalogservice_march2025.services;

import com.example.productcatalogservice_march2025.models.Product;
import com.example.productcatalogservice_march2025.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StorageProductService implements IProductService
{
    @Autowired
    private ProductRepositories productRepositories;

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product=productRepositories.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositories.save(product);
    }

    @Override
    public Product replaceProduct(long id, Product product) {
        return null;
    }
}
