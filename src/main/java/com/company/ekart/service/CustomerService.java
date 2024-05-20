package com.company.ekart.service;

import com.company.ekart.dto.CustomerDTO;
import com.company.exception.EkartException;

public interface CustomerService {

	CustomerDTO authenticateCustomer(String emailId, String password) throws EkartException;

	String registerNewCustomer(CustomerDTO customerDTO) throws EkartException;

	void updateShippingAddress(String customerEmailId, String address) throws EkartException;

	void deleteShippingAddress(String customerEmailId)throws EkartException;

}
