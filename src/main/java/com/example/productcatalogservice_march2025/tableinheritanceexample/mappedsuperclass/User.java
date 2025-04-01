package com.example.productcatalogservice_march2025.tableinheritanceexample.mappedsuperclass;

import jakarta.persistence.*;


@MappedSuperclass
public abstract class User
{
    @Id
    private long id;
    private String name;
    private String email;
}
