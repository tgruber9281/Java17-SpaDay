package org.launchcode.models;

import jakarta.validation.constraints.Email;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Trevor Gruber
 */
public class User {

/** fields */
    private final int userId;
    private static int nextId = 1;
    private String username;
    @Email
    private String email;
    private String password;
    private static final ZoneId z = ZoneId.of( "America/Chicago" );
    private LocalDate dateAdded;
    
    /** Constructor(s) */
    public User(String username, String email, String password) {
        this.userId = nextId;
        nextId++;
        this.username = username;
        this.email = email;
        this.password = password;
        dateAdded = LocalDate.now(z);
    }
    /** Custom methods */

/** Getters and Setters */
    public int getUserId() {
        return userId;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public LocalDate getDateAdded() {
        return dateAdded;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    /** toString */

/** Equals and Hashcode*/

}
