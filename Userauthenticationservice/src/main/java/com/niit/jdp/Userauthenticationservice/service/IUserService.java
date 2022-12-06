package com.niit.jdp.Userauthenticationservice.service;

import com.niit.jdp.Userauthenticationservice.domain.User;
import com.niit.jdp.Userauthenticationservice.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public User saveUser(User user);
    public List<User> getAllUser();
    public User loginCheck(String username,String password)throws UserNotFoundException;
    public Optional<User> getbyUserId(int uid);
}
