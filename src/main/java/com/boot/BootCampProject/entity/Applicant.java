package com.boot.BootCampProject.entity;

import com.boot.BootCampProject.core.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "applicants")
public class Applicant extends User {

    private String about;

    public Applicant() {}

    public Applicant(int id, String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password, String about) {
        super(id, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.about = about;
    }
    public String getAbout() {return about;}

    public void setAbout(String about) {this.about = about;}
}
