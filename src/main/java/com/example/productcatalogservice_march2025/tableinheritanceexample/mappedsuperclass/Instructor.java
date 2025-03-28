package com.example.productcatalogservice_march2025.tableinheritanceexample.mappedsuperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="msc_instructor")
@DiscriminatorValue(value="3")
public class Instructor extends User
{
    private String company;
}
