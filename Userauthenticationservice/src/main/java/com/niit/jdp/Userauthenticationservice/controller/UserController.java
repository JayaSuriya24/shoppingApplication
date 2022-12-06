/*
 * Author Name: M Jaya Suriya
 * Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.Userauthenticationservice.controller;

import com.niit.jdp.Userauthenticationservice.domain.User;
import com.niit.jdp.Userauthenticationservice.exception.UserNotFoundException;
import com.niit.jdp.Userauthenticationservice.service.IUserService;
import com.niit.jdp.Userauthenticationservice.service.SecurityTokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private IUserService iUserService;
    private SecurityTokenGenerator securityTokenGenerator;

    public UserController(IUserService iUserService,SecurityTokenGenerator securityTokenGenerator){
        this.iUserService=iUserService;
        this.securityTokenGenerator=securityTokenGenerator;
    }
    @PostMapping("/register")
    public ResponseEntity<?> saveFun1(@RequestBody User user)
    {
        return  new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/api/v1/fetchall")
    public ResponseEntity<?> fetchFun1()
    {
        return  new ResponseEntity<>(iUserService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping("/api/v1/fetchbyid/{id}")
    public ResponseEntity<?> fetchFun2(@PathVariable int id)
    {
        return new ResponseEntity<>(iUserService.getbyUserId(id),HttpStatus.OK);
    }

    @GetMapping("/login")
    public  ResponseEntity<?> loginFun1(@RequestBody User user) throws UserNotFoundException {
       try{
           iUserService.loginCheck(user.getUsername(),user.getPassword());
           Map<String,String> secretkey=new HashMap<>();
           secretkey=securityTokenGenerator.generateToken(user);
           return new ResponseEntity<>(secretkey,HttpStatus.OK);
       }
       catch (UserNotFoundException e)
       {
           throw new UserNotFoundException();
       }catch (Exception e){
           return new ResponseEntity<>("!NETWORK ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
}
