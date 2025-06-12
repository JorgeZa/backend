package com.gogreen.repo;

import com.gogreen.model.CartItem;
import com.gogreen.model.CartItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, CartItemPK> {
}
