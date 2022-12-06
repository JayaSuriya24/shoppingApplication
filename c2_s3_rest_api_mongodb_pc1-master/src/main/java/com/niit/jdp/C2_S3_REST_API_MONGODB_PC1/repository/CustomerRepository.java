/*
 * Author Name: M Jaya Suriya
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */

package com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.repository;

import com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    @Query("{'customerProduct.productName':{$in:[?0]}}")
    List<Customer> findAllCustomersProductName(String customerProductName);
}
