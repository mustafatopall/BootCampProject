package com.boot.BootCampProject.entity;

import com.boot.BootCampProject.core.entity.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "applicants")
public class Applicant extends User {

    private String about;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL)
    private List<Application> applications;

    public Applicant() {}

    public Applicant(int id, String firstName, String lastName, String dateOfBirth, String nationalIdentity, String email, String password, String about) {
        super(id, firstName, lastName, dateOfBirth, nationalIdentity, email, password);
        this.about = about;
    }

    public String getAbout() { return about; }

    public void setAbout(String about) { this.about = about; }

    public List<Application> getApplications() { return applications; }

    public void setApplications(List<Application> applications) { this.applications = applications; }
}
