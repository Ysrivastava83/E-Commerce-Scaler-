package com.example.productcatalogservice_march2025.tableinheritanceexample.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name="tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User
{
    @Id
    private long id;
    private String name;
    private String email;
}
