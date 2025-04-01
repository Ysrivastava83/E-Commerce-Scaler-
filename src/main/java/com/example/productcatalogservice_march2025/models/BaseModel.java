package com.example.productcatalogservice_march2025.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel
{
    @Id
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;
}
