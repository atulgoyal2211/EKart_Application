package com.company.ekart.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartProductDTO {
	private Integer cartProductId;
	private ProductDTO product;
	private Integer quantity;
}
