package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    @Query(
            value = "SELECT p FROM Product p WHERE p IN (SELECT po.product FROM ProductOrder po WHERE po.order = :order)",
            nativeQuery = false)
    List<Product> getAllProductsByOrderId(Order order);

}
