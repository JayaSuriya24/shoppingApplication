/*
* Author Name: M Jaya Suriya
* Date: 11/29/2022
* Created With: IntelliJ IDEA Community Edition
*/
package com.niit.jdp.Userauthenticationservice.service;

import com.niit.jdp.Userauthenticationservice.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String,String> generateToken(User user);
}