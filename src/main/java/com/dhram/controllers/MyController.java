package com.dhram.controllers;

import com.dhram.dto.CategoryDto;
import com.dhram.dto.ProductDto;
import com.dhram.entities.Category;
import com.dhram.entities.Product;
import com.dhram.entities.User;
import com.dhram.repositories.UserRepo;
import com.dhram.services.CategoryService;
import com.dhram.services.ProductService;
import com.dhram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MyController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @GetMapping()
    public String getConnected(){
        return "server running on port 8080";
    }
    @GetMapping("/getCategories")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>> getProducts(){
        return productService.getAllProducts();
    }
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("/getUser/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
        return userService.getUser(email);
    }

}
