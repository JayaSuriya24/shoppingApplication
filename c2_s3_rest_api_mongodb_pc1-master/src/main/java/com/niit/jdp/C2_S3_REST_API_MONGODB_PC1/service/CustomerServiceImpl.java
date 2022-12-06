/*
 * Author Name: M Jaya Suriya
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.service;

import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.domain.Customer;
import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.exception.CustomerNotFoundException;
import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
        boolean flag = false;
        if (customerRepository.findById(customerId).isEmpty()) {
            throw new CustomerNotFoundException();
        } else {
            customerRepository.deleteById(customerId);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Customer> getAllCustomersByProductName(String customerProductName) throws CustomerNotFoundException {
        if (customerRepository.findAllCustomersProductName(customerProductName).isEmpty()) {
            throw new CustomerNotFoundException();
        }
        return customerRepository.findAllCustomersProductName(customerProductName);
    }
}