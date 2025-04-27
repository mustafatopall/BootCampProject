package com.boot.BootCampProject.core.entity;

import jakarta.persistence.*;

@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String nationalIdentity;
    private String email;
    private String password;

    public User() {}


    public User(int id, String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationalIdentity = nationalIdentity;
        this.email = email;
        this.password = password;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getDateOfBirth() {return dateOfBirth;}

    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public String getNationalIdentity() {return nationalIdentity;}

    public void setNationalIdentity(String nationalIdentity) {this.nationalIdentity = nationalIdentity;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
