package com.company.ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.ekart.dto.ProductDTO;
import com.company.ekart.entity.Product;
import com.company.ekart.respository.ProductRepository;
import com.company.exception.EkartException;

@Service(value="customerProductService")
public class CustomerProductServiceImpl implements CustomerProductService {

	@Autowired
	public ProductRepository productRepository;

	@Override
	public List<ProductDTO> getAllProduct() {
		Iterable<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		products.forEach(product -> {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setBrand(product.getBrand());
			productDTO.setCategory(product.getCategory());
			productDTO.setDescription(product.getDescription());
			productDTO.setName(product.getName());
			productDTO.setPrice(product.getPrice());
			productDTO.setProductId(product.getProductId());
			productDTO.setAvailableQuantity(product.getAvailableQuantity());

			productDTOs.add(productDTO);
		});
		return productDTOs;
	}

	@Override
	public ProductDTO getProductById(Integer productId) throws EkartException {
		Optional<Product> optional = productRepository.findById(productId);
		Product product = optional.orElseThrow(() -> new EkartException("ProductService.PRODUCT_NOT_AVAILABLE"));

		ProductDTO productDTO = new ProductDTO();
		productDTO.setBrand(product.getBrand());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setProductId(product.getProductId());
		productDTO.setAvailableQuantity(product.getAvailableQuantity());
		return productDTO;
	}
}
