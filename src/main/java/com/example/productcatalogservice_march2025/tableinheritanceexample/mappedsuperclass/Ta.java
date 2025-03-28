package com.example.productcatalogservice_march2025.tableinheritanceexample.mappedsuperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="msc_ta")
@DiscriminatorValue(value = "1")
public class Ta extends User
{
    private Integer ratings;
}
