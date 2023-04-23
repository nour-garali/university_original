package com.nour.university.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nour.university.entities.University;
public interface UniversityRepository extends JpaRepository<University, Long> {

}
