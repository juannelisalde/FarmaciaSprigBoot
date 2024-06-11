package com.unir.farmacia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pedido_tipo")
public class OrderTypeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotBlank
  @Column(name = "tipo", unique = true, nullable = false)
  private String type;

  // @OneToMany(targetEntity = OrderEntity.class, cascade = CascadeType.ALL)
  // @JoinColumn(name = "tipo_id", referencedColumnName = "id")
  // @ToString.Exclude
  // private List<OrderEntity> orders;
}
