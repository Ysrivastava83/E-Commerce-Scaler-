package com.example.productcatalogservice_march2025.tableinheritanceexample.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="joined_instructor")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User
{
    private String company;
}
