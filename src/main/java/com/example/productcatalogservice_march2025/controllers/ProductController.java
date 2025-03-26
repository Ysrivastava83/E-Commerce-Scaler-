package com.example.productcatalogservice_march2025.controllers;

import com.example.productcatalogservice_march2025.dtos.CategoryDto;
import com.example.productcatalogservice_march2025.dtos.ProductDto;
import com.example.productcatalogservice_march2025.models.Category;
import com.example.productcatalogservice_march2025.models.Product;
import com.example.productcatalogservice_march2025.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;


    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts()
    {
            List<Product> products = iProductService.getAllProducts();
            List<ProductDto> productDtos = new ArrayList<>();
            for(Product p:products)
            {
                productDtos.add(getProductDto(p));
            }
            return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long productId) {
        try {
            if (productId <= 0) {
                throw new IllegalArgumentException("Invalid product id");
            }
            Product product = iProductService.getProductById(productId);
            ProductDto productDto = getProductDto(product);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("called by user", "Yuvraj");
            return new ResponseEntity<>(productDto, map, HttpStatus.OK);
        }
        catch (IllegalArgumentException e) {
                throw e;
            // return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ProductDto replaceProduct(@PathVariable("id") long productId,@RequestBody ProductDto productDto)
    {           Product product = getProduct(productDto);
                Product newProduct= iProductService.replaceProduct(productId,product);
                return getProductDto(newProduct);
    }


    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto)
    {
        Product  product=getProduct(productDto);
       // System.out.println(product);
        Product newProduct=iProductService.createProduct(product);
        return getProductDto(newProduct);
    }


    private ProductDto getProductDto(Product product)
    {
        ProductDto productDto=new ProductDto();
        productDto.setDescription(product.getDescription());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());

        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setName(product.getCategory().getName());
        productDto.setCategory(categoryDto);
        return productDto;
    }

    private Product getProduct(ProductDto productDto)
    {
        Product product=new Product();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        Category category=new Category();
        category.setName(productDto.getCategory().getName());
        product.setCategory(category);
        return product;
    }
}
