package com.unir.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.farmacia.entity.OrderEntity;
import java.util.List;


public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
  // findByName lowercase
  List<OrderEntity> findByNameIgnoreCaseContaining(String name);
}
