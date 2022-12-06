/*
 * Author Name: M Jaya Suriya
 * Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jdp.Userauthenticationservice.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private int uid;
    private  String firstname;
    private String lastname;
    private String username;
    private String password;
    private long mobileno;

    public User() {
    }

    public User(int uid, String firstname, String lastname, String username, String password, long mobileno) {
        this.uid = uid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.mobileno = mobileno;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobileno=" + mobileno +
                '}';
    }
}
