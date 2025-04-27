package com.boot.BootCampProject.repository;

import com.boot.BootCampProject.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
}
