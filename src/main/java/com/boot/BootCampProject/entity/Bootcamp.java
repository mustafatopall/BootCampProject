package com.boot.BootCampProject.entity;

import com.boot.BootCampProject.entity.enums.BootcampState;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "bootcamps")
public class Bootcamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String startDate;
    private String endDate;

    @Enumerated(EnumType.STRING)
    private BootcampState bootcampState;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @OneToMany(mappedBy = "bootcamp", cascade = CascadeType.ALL)
    private List<Application> applications;

    public Bootcamp() {}

    public Bootcamp(String name, Instructor instructor, String startDate, String endDate, BootcampState bootcampState) {
        this.name = name;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bootcampState = bootcampState;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getStartDate() { return startDate; }

    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }

    public void setEndDate(String endDate) { this.endDate = endDate; }

    public BootcampState getBootcampState() { return bootcampState; }

    public void setBootcampState(BootcampState bootcampState) { this.bootcampState = bootcampState; }

    public Instructor getInstructor() { return instructor; }

    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    public List<Application> getApplications() { return applications; }

    public void setApplications(List<Application> applications) { this.applications = applications; }
}
