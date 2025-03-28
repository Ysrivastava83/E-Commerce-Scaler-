package com.example.productcatalogservice_march2025.tableinheritanceexample.tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tcp_ta")
public class Ta extends User
{
    private Integer ratings;
}
