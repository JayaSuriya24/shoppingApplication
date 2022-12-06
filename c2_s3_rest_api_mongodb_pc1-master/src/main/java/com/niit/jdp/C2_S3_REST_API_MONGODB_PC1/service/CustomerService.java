/*
 * Author Name: M Jaya Suriya
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.service;

import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.domain.Customer;
import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAllCustomers() throws Exception;

    boolean deleteCustomer(int customerId) throws ClassNotFoundException, CustomerNotFoundException;

    List<Customer> getAllCustomersByProductName(String customerProductName) throws CustomerNotFoundException;
}
