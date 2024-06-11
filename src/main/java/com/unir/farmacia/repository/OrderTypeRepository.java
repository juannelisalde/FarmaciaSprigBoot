package com.unir.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unir.farmacia.dto.OrderResponse;
import com.unir.farmacia.entity.OrderTypeEntity;

public interface OrderTypeRepository extends JpaRepository<OrderTypeEntity, Integer>{
  @Query("SELECT new com.unir.farmacia.dto.OrderResponse(p.name, p.quantity, t.type) FROM OrderEntity p JOIN p.orderTypes t")
  public List<OrderResponse> getJoinInformation();
}
