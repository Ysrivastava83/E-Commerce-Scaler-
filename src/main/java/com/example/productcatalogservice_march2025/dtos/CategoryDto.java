package com.example.productcatalogservice_march2025.dtos;

import com.example.productcatalogservice_march2025.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDto
{
    private String name;
    private String description;
   // private List<Product> productList=new ArrayList<>();
}
