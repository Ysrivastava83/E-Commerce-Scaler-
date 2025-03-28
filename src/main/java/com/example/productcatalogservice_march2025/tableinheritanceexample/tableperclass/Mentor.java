package com.example.productcatalogservice_march2025.tableinheritanceexample.tableperclass;

import jakarta.persistence.Entity;

@Entity(name="tcp_mentor")
public class Mentor extends User{

    private long   noOfHours;
}
