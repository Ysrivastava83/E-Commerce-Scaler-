package com.example.productcatalogservice_march2025.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseModel
{
    private long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;
}
