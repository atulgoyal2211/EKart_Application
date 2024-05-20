package com.company.ekart.service;

import java.util.List;

import com.company.ekart.dto.ProductDTO;
import com.company.exception.EkartException;

public interface CustomerProductService {
	
	public List<ProductDTO> getAllProduct();

	public ProductDTO getProductById(Integer productId) throws EkartException;

}
