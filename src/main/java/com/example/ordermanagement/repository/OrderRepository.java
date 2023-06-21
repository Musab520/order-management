package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(
            value = "SELECT * FROM orders o WHERE o.customer_id = :id",
            nativeQuery = true)
    List<Order> getAllOrdersByCustomerId(long id);
}
