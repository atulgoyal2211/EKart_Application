package com.company.ekart.entity;

import com.company.ekart.dto.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Ek_CARTPRODUCT")
public class CartProduct {
	@Id
	private Integer cartProductId;
	private ProductDTO product;
	private Integer quantity;

}
