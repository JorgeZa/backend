package com.gogreen.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String address;
    private String phone;
    @JsonManagedReference
    private List<CartItem> cartItems = new ArrayList<>();
}
