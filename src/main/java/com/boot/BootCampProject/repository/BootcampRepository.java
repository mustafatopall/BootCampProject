package com.boot.BootCampProject.repository;

import com.boot.BootCampProject.entity.Bootcamp;
import com.boot.BootCampProject.entity.enums.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {
    List<Bootcamp> findByBootcampState(BootcampState bootcampState);
}
