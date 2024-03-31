package com.dhram.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Proxy;

@Data
@RequiredArgsConstructor
@Entity
@Proxy(lazy = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(name = "mobileNo")
    private String mobileNo;
    private String address;
    private String image;
    @Column(name = "isAdmin")
    private boolean isAdmin;

}
