package com.example.productcatalogservice_march2025.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel
{
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private Category category;
   // private boolean isPrime;
}
