package com.example.productcatalogservice_march2025.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto
{
    private long id;
    private String title;
    private String description;
    private String image;
    private double price;
    private String category;
    private FakeStoreRatingDto fakeStoreRatingDto;
}
