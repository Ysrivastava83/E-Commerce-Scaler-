package com.example.productcatalogservice_march2025.tableinheritanceexample.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="joined_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {

    private long   noOfHours;
}
