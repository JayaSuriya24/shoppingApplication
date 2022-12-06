/*
 * Author Name: M Jaya Suriya
 * Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.Userauthenticationservice.service;

import com.niit.jdp.Userauthenticationservice.domain.User;
import com.niit.jdp.Userauthenticationservice.exception.UserNotFoundException;
import com.niit.jdp.Userauthenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User loginCheck(String username, String password) throws UserNotFoundException {
        User userobj=userRepository.findByUsernameAndPassword(username,password);
        if (userobj==null){
            throw new UserNotFoundException();
        }
        return userobj;
    }


    @Override
    public Optional<User> getbyUserId(int uid) {
        return userRepository.findById(uid);
    }
}
