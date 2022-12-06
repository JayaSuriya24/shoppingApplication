/*
 * Author Name: M Jaya Suriya
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.controller;

import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.domain.Customer;
import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.exception.CustomerNotFoundException;
import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.exception.ProductNotFoundException;
import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/savecustomer")
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping(value = "/fetchallcustomers")
    public ResponseEntity<?> getAllCustomers() {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    @DeleteMapping(value = "/deletecustomerbyid/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) throws CustomerNotFoundException {
        ResponseEntity responseEntity = null;
        try {
            customerService.deleteCustomer(customerId);
            responseEntity = new ResponseEntity<>("successfully deleted one record", HttpStatus.OK);
        } catch (CustomerNotFoundException e) {
            throw new CustomerNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(value = "/customer/{productName}")
    public ResponseEntity<?> getAllCustomersByProductName(@PathVariable String productName) throws ProductNotFoundException {
        ResponseEntity responseEntity = null;
        try {
            responseEntity = new ResponseEntity(customerService.getAllCustomersByProductName(productName), HttpStatus.OK);

        } catch (CustomerNotFoundException e) {

            throw new ProductNotFoundException();
        }
        return responseEntity;
    }
}