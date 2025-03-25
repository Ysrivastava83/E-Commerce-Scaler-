package com.example.productcatalogservice_march2025.services;

import com.example.productcatalogservice_march2025.clients.FakeStoreClient;
import com.example.productcatalogservice_march2025.dtos.FakeStoreProductDto;
import com.example.productcatalogservice_march2025.dtos.ProductDto;
import com.example.productcatalogservice_march2025.models.Category;
import com.example.productcatalogservice_march2025.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FakeStoreProductService implements IFakeStoreProductService
{
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<Product> getAllProducts()
    {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto[] fakeStoreProductDtoList = restTemplate
                .getForEntity("https://fakestoreapi.com/products/", FakeStoreProductDto[].class)
                .getBody();
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtoList)
        {
            products.add(getProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product getProductById(Long proudcutId)
    {
        return getProduct(fakeStoreClient.getProduct(proudcutId));
    }

    @Override
    public Product replaceProduct(long id,Product product)
    {
        FakeStoreProductDto fakeStoreProductDto =getFakeStoreProductDto(product);
      FakeStoreProductDto fakeStoreProductDtoResponse = requestForEntity(HttpMethod.PUT,"https://fakestoreapi.com/products/{id}",fakeStoreProductDto,FakeStoreProductDto.class,id).getBody();
      return getProduct(fakeStoreProductDtoResponse);
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }


    @Override
    public Product createProduct(Product product)
    {
        return null;
    }

    private Product getProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDto getFakeStoreProductDto(Product product)
    {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(product.getName());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setImage(product.getImageUrl());
        if(product.getCategory()!=null)
        {
            fakeStoreProductDto.setCategory(product.getCategory().getName());
        }
        return fakeStoreProductDto;
    }

}
