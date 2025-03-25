package com.example.productcatalogservice_march2025.dtos;

import com.example.productcatalogservice_march2025.models.Category;
import com.example.productcatalogservice_march2025.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto
{
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private CategoryDto category;
}
