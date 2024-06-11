package com.sgb.www.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Geo geo;
    private Address address;
    
    // Other fields, getters, and setters
}
