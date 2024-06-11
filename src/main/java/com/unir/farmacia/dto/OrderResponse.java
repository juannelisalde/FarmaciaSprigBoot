package com.unir.farmacia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderResponse {
  private String name;
  private int quantity;
  private String type;

  public OrderResponse(String name, String quantity, String type) {
    this.name = name;
    this.quantity = Integer.parseInt(quantity);
    this.type = type;
  }
}
