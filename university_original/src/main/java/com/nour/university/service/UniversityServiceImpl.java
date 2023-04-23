package com.nour.university.service;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nour.university.entities.University;
import com.nour.university.repos.UniversityRepository;


@Service
public class UniversityServiceImpl implements UniversityService {
@Autowired
UniversityRepository universityRepository;
@Override
public University saveUniversity(University u) {
return universityRepository.save(u);
}
@Override
public  University updateUniversity( University u) {
return universityRepository.save(u);
}


@Override
public void deleteUniversity(University u) {
	universityRepository.delete(u);
}
 @Override
public void deleteUniversityById(Long id) {
	 universityRepository.deleteById(id);
}
@Override
public University getUniversity(Long id) {
return universityRepository.findById(id).get();
}
@Override
public List<University> getAllUniversity() {
return universityRepository.findAll();
}



@Override
public Page<University> getAllUniversityParPage(int page, int size) {
return universityRepository.findAll(PageRequest.of(page, size));
}




}