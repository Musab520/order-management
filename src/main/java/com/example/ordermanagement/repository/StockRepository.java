package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query(
            value = "SELECT s FROM Stock s WHERE s.product IN (SELECT p FROM Product p WHERE p IN (SELECT po.product FROM ProductOrder po WHERE po.order = :order))",
            nativeQuery = false)
    List<Stock> getAllStocksByOrderId(Order order);
}
