package com.boot.BootCampProject.entity;

import com.boot.BootCampProject.core.entity.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor extends User {

    private String companyName;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Bootcamp> bootcamps;

    public Instructor() {}

    public Instructor(int id, String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password, String companyName) {
        super(id, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.companyName = companyName;
    }


    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public List<Bootcamp> getBootcamps() { return bootcamps; }

    public void setBootcamps(List<Bootcamp> bootcamps) { this.bootcamps = bootcamps; }
}
