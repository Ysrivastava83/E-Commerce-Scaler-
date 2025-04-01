package com.example.productcatalogservice_march2025.tableinheritanceexample.singletable;

import jakarta.persistence.*;

@Entity(name="st_user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User Type",discriminatorType = DiscriminatorType.INTEGER)
public class User
{
    @Id
    private long id;
    private String name;
    private String email;
}
