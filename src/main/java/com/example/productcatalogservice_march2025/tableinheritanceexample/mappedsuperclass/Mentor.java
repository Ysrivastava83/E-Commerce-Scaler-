package com.example.productcatalogservice_march2025.tableinheritanceexample.mappedsuperclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="msc_mentor")
@DiscriminatorValue(value="2")
public class Mentor extends User {

    private long   noOfHours;
}
