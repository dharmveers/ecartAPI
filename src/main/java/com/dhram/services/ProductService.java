package com.dhram.services;


import com.dhram.dto.ProductDto;
import com.dhram.entities.Product;
import com.dhram.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products;
        products= productRepo.findAll().stream().map(p->{
            return new ProductDto(p.getId(), p.getName(), p.getDescription(), p.getImage(), p.getPrice(), p.getDescount(), p.getQty() ,p.getCategory().getId());
        }).collect(Collectors.toList());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
