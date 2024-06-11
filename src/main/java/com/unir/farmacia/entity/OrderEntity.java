package com.unir.farmacia.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank; 
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "pedido")
public class OrderEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotBlank
  @Column(name = "nombre", nullable = false)
  private String name;

  @NotNull
  @Column(name = "cantidad", nullable = false)
  private int quantity;

  @NotBlank
  @Column(name = "distribuidor", nullable = false)
  private String distributor;

  @NotBlank
  @Column(name = "direccion", nullable = false)
  private String address;

  @NotNull
  @Column(name = "tipo_id")
  private int type;

  @ManyToOne(targetEntity = OrderTypeEntity.class)
  @JoinColumn(name = "tipo_id", referencedColumnName = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name="fk_pedido_tipo"))
  private OrderTypeEntity orderTypes;
}
/* 
drop database if exists farmacia;
create database farmacia;
 */