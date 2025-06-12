package com.gogreen.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false, length = 35)
    private String username;

    @Column(nullable = false, length = 128)
    private String password;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 128)
    private String address;

    @Column(nullable = false, length = 15)
    private String phone;

    @JsonManagedReference
    @OneToMany(mappedBy = "pk.user", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

    @Transient
    public BigDecimal getCartTotal() {
        BigDecimal sum = BigDecimal.ZERO;

        for (CartItem item : cartItems) {
            sum = sum.add(item.getTotalPrice());
        }
        return sum;
    }
    public User (String username, String password, String email, String name, String address, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cartItems = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", cartItems=" + cartItems +
                '}';
    }
}