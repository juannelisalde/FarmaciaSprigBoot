package com.unir.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.farmacia.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

}
