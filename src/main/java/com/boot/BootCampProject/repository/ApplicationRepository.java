package com.boot.BootCampProject.repository;

import com.boot.BootCampProject.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {
    List<Application> findByApplicantId(int applicantId);
}
