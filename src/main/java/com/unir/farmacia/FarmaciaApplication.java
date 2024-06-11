package com.unir.farmacia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.unir.farmacia.entity.OrderEntity;
import com.unir.farmacia.entity.OrderTypeEntity;
import com.unir.farmacia.repository.OrderRepository;
import com.unir.farmacia.repository.OrderTypeRepository;

@SpringBootApplication
public class FarmaciaApplication {
	public static void main(String[] args) {
		SpringApplication.run(FarmaciaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(OrderTypeRepository orderTypeRepository, OrderRepository orderRepository) {
		return (args) -> {
			orderTypeRepository.save(new OrderTypeEntity(1, "analgésico"));
			orderTypeRepository.save(new OrderTypeEntity(2, "analéptico"));
			orderTypeRepository.save(new OrderTypeEntity(3, "anestésico"));
			orderTypeRepository.save(new OrderTypeEntity(4, "antiácido"));
			orderTypeRepository.save(new OrderTypeEntity(5, "antidepresivo"));
			orderTypeRepository.save(new OrderTypeEntity(6, "antibióticos"));

			orderRepository.save(new OrderEntity(1, "Paracetamol", 1, "Copifam", "calle 1 # 4 57", 1, null));

		};
	}

}

/* 
drop database farmacia;
create database farmacia;
 */