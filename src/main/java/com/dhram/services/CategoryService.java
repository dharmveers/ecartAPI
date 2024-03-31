package com.dhram.services;

import com.dhram.dto.CategoryDto;
import com.dhram.entities.Category;
import com.dhram.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categories = new ArrayList<>();
        for(Category c:categoryRepo.findAll()){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(c.getId());
            categoryDto.setName(c.getName());
            categoryDto.setDescription(c.getDescription());
            categoryDto.setProdList(c.getProducts().stream().map(p->p.getId()).collect(Collectors.toList()));
            categories.add(categoryDto);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
