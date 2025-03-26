package com.example.productcatalogservice_march2025.test;

import lombok.Getter;
import lombok.Setter;


public class Test
{
    public static void main(String[] args)
    {
        LombokTest test=new LombokTest();
        test.setName("Test Passed");
        System.out.println(test.getName());
    }
}

@Setter
@Getter
 class LombokTest
{
    private String name="";
}
