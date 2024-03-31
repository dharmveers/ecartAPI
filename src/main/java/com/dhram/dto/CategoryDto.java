package com.dhram.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CategoryDto {
    private Integer id;
    private String name;
    private String description;
    private List<Integer> prodList;
}
