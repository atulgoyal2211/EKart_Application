package com.company.ekart.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerCartDTO {
	private Integer cartId;
	private String customerEmailId;
	private Set<CartProductDTO> cartProdcuts;
}
