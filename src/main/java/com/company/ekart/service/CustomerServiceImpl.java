package com.company.ekart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.ekart.dto.CustomerDTO;
import com.company.ekart.entity.Customer;
import com.company.ekart.respository.CustomerRepository;
import com.company.exception.EkartException;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO authenticateCustomer(String emailId, String password) throws EkartException {
		CustomerDTO customerDTO = null;
		Optional<Customer> optionalCustomer = customerRepository.findById(emailId);
		Customer customer = optionalCustomer
				.orElseThrow(() -> new EkartException("CustomerService.CUSTOMER_NOT_FOUND"));
		if (!password.equals(customer.getPassword())) {
			throw new EkartException("CustomerService.INVALID_CREDENTIALS");
		}
		customerDTO = new CustomerDTO();
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		customerDTO.setPhoneNumber(customer.getPhoneNumber());
		customerDTO.setAddress(customer.getAddress());

		return customerDTO;
	}

//	This method will Register New Customer
	@Override
	public String registerNewCustomer(CustomerDTO customerDTO) throws EkartException {
		String registeredWithEmailId = null;
		boolean isEmailNotAvailable = customerRepository.findById(customerDTO.getEmailId().toLowerCase()).isEmpty();
		boolean isPhoneNumberNotAvailable = customerRepository.findById(customerDTO.getPhoneNumber()).isEmpty();
		if (isEmailNotAvailable) {
			if (isPhoneNumberNotAvailable) {
				Customer customer = new Customer();
				customer.setEmailId(customerDTO.getEmailId());
				customer.setName(customerDTO.getName());
				customer.setPassword(customerDTO.getPassword());
				customer.setPhoneNumber(customerDTO.getPhoneNumber());
				customer.setAddress(customerDTO.getAddress());
				customerRepository.save(customer);
				registeredWithEmailId = customer.getEmailId();
			} else {
				throw new EkartException("CustomerService.PHONE_NUMBER_ALREADY_IN_USE");
			}
		} else {
			throw new EkartException("CustomerService.EMAIL_ID_ALREADY_IN_USE");
		}
		return registeredWithEmailId;
	}
	
//	This method will Update the Address of the Customer
	@Override
	public void updateShippingAddress(String customerEmailId, String address) throws EkartException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerEmailId.toLowerCase());
		Customer customer = optionalCustomer
				.orElseThrow(() -> new EkartException("CustomerService.CUSTOMER_NOT_FOUND"));
		customer.setAddress(address);
	}

	@Override
	public void deleteShippingAddress(String customerEmailId) throws EkartException {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerEmailId);
		Customer customer = optionalCustomer
				.orElseThrow(() -> new EkartException("CustomerService.CUSTOMER_NOT_FOUND"));
		customer.setAddress(null);
	}
}
