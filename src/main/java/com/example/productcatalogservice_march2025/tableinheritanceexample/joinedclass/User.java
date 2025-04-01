package com.example.productcatalogservice_march2025.tableinheritanceexample.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name="joined_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User
{
    @Id
    private long id;
    private String name;
    private String email;
}
