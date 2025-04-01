package com.example.productcatalogservice_march2025.tableinheritanceexample.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="joined_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class Ta extends User
{
    private Integer ratings;
}
