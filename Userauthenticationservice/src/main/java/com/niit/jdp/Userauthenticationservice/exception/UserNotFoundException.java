/*
 * Author Name: M Jaya Suriya
 * Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.Userauthenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Invalid Username (or) Password")
public class UserNotFoundException extends Exception{
}
