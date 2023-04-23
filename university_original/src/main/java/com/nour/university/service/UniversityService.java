package com.nour.university.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nour.university.entities.University;

public interface UniversityService {
University saveUniversity(University u);
University updateUniversity(University u);
void deleteUniversity(University u);
 void deleteUniversityById(Long idUniversity);
 University getUniversity(Long idUniversity);
List<University> getAllUniversity();
Page<University> getAllUniversityParPage(int page, int size);

}
