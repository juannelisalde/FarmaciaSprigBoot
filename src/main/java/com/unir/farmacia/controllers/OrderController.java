package com.unir.farmacia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.unir.farmacia.dto.OrderResponse;
import com.unir.farmacia.entity.OrderEntity;
import com.unir.farmacia.entity.OrderTypeEntity;
import com.unir.farmacia.repository.OrderRepository;
import com.unir.farmacia.repository.OrderTypeRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/farmacia")
public class OrderController {
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private OrderTypeRepository orderTypeRepository;

  @GetMapping("/")
  public List<OrderEntity> findAll() {
    return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @GetMapping("/{id}")
  public OrderEntity findById(@PathVariable int id) {
    if(!orderRepository.findById(id).isPresent())
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado");
      
    return orderRepository.findById(id).get();
  }

  @GetMapping("/search/{name}")
  public List<OrderEntity> findByName(@PathVariable String name) {
    return orderRepository.findByNameIgnoreCaseContaining(name);
  }
  
  @GetMapping("/getQuery")
  public List<OrderResponse> getJoinInformation() {
    return orderTypeRepository.getJoinInformation();
  }

  @GetMapping("/tipos")
  public List<OrderTypeEntity> getTypes() {
    return orderTypeRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @CrossOrigin(origins = "*")
  @PostMapping
  public String save(@Valid @RequestBody OrderEntity entity) {
    try {
      orderRepository.save(entity);
      return "Pedido guardado con éxito";
    } catch (DataIntegrityViolationException e) {
      return "El tipo de pedido enviado no existe o no fue enviado, type";
    } catch (Exception e) {
      return "Error al guardar " + e.getMessage();
    }
  }

  @CrossOrigin(origins = "*")
  @PutMapping("/{id}")
  public String update(@PathVariable int id, @Valid @RequestBody OrderEntity entity) {
    try {
      orderRepository.findById(id).get();
      
      OrderEntity order = entity;
      order.setId(id);
      orderRepository.save(order);
      return "Pedido editado con éxito";
    } catch (DataIntegrityViolationException e) {
      return "El tipo de pedido enviado no existe o no fue enviado, type";
    } catch (Exception e) {
      return "Pedido no encontrado ";
    }

  }

  @CrossOrigin(origins = "*")
  @DeleteMapping("/{id}")
  public String delete(@PathVariable int id) {
    try {
      orderRepository.findById(id).get();
      orderRepository.deleteById(id);
      return "Pedido eliminado con éxito";
    } catch (Exception e) {
      return "Pedido no encontrado";
    }
  }
}
