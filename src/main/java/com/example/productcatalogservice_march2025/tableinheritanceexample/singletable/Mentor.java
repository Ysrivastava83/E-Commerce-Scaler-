package com.example.productcatalogservice_march2025.tableinheritanceexample.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name="st_mentor")
@DiscriminatorValue(value="2")
public class Mentor extends User {

    private long   noOfHours;
}
