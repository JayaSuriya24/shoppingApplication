/*
 * Author Name: M Jaya Suriya
 * Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */


package com.niit.jdp.C2_S3_REST_API_MONGODB_PC1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends Exception {
}
