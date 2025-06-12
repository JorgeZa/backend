package com.gogreen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
public class CartItem {
    @EmbeddedId
    @JsonIgnore
    private CartItemPK pk;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date addedOn = new Date();

    @Column(nullable = false)
    private int quantity = 1;

    public CartItem (User user, Product product, int quantity) {
        pk = new CartItemPK();
        pk.setUser(user);
        pk.setProduct(product);
        this.quantity = quantity;
    }
    @Transient
    public Product getProduct () {
        return pk.getProduct();
    }

    @Transient
    public BigDecimal getTotalPrice () {
        return getProduct().getPrice().multiply(new BigDecimal(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CartItem that = (CartItem) o;
        return Objects.equals(pk.getUser().getId(), that.pk.getUser().getId()) &&
                Objects.equals(getProduct().getId(), that.getProduct().getId());
    }
}
