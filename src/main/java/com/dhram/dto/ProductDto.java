package com.dhram.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private double price;
    private Integer descount;
    private Integer qty;
    private Integer category_id;
    public double getActualPrice(){
        return this.price-((this.price*this.descount)/100.0);
    }
}
