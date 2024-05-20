package com.company.ekart.api;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.ekart.dto.ProductDTO;
import com.company.ekart.service.CustomerProductService;
import com.company.exception.EkartException;

@RestController
@RequestMapping(value = "/product-api")
public class ProductAPI {

	@Autowired
	private CustomerProductService customerProductService;

	@Autowired
	private Environment environment;

	Log logger = LogFactory.getLog(ProductAPI.class);

	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDTO>> getAllProduct() {
		List<ProductDTO> productList = customerProductService.getAllProduct();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@GetMapping(value = "/product/{productId}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer productId) throws EkartException {
		ProductDTO product = customerProductService.getProductById(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	public ResponseEntity<ProductDTO> addProduct() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
