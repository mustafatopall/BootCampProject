package com.boot.BootCampProject.entity;

import com.boot.BootCampProject.core.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends User {
    private String position;

    public Employee() {}

    public Employee(int id, String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password,String position) {
        super(id, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.position = position;
    }

    public String getPosition() {return position;}

    public void setPosition(String position) {this.position = position;}
}
