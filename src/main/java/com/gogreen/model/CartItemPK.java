package com.gogreen.model;

import static jakarta.persistence.FetchType.LAZY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CartItemPK {
    @JsonBackReference
    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(optional = false, fetch = LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CartItemPK that = (CartItemPK) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(user, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, product);
    }

}
