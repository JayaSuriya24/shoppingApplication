package com.niit.jdp.Userauthenticationservice.repository;

import com.niit.jdp.Userauthenticationservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByUsernameAndPassword(String username,String password);
}
