package com.example.productcatalogservice_march2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel
{
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> productList=new ArrayList<>();
}
