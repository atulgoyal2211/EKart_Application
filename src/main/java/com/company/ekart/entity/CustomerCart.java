package com.company.ekart.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Ek_CUSTOMERCART")
@Getter @Setter
public class CustomerCart {
	@Id
	private Integer cartId;
	private String customerEmailId;
	private Set<CartProduct> cartProducts;	
}
