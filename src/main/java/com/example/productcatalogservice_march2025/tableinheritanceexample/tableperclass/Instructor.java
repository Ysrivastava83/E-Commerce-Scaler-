package com.example.productcatalogservice_march2025.tableinheritanceexample.tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tcp_instructor")
public class Instructor extends User
{
    private String company;
}
