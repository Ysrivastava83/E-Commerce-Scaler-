package com.example.productcatalogservice_march2025.services;

import com.example.productcatalogservice_march2025.models.Product;

import java.util.List;

public interface IProductService
{
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product replaceProduct(long id, Product product);
}
