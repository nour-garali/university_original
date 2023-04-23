package com.nour.university;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;


import com.nour.university.entities.University;
import com.nour.university.repos.UniversityRepository;
import com.nour.university.service.UniversityService;


@SpringBootTest
class ProduitsApplicationTests {
@Autowired
private UniversityRepository universityRepository;


@Autowired
private UniversityService universityService;

@Test
public void testCreateProduit() {
	University prod = new University("iset rades", "tunis", 65, new Date());
universityRepository.save(prod);
}



@Test
public void testFindUniversity()
{
University p = universityRepository.findById(1L).get(); 
System.out.println(p);
}
@Test
public void testUpdateUniversity()
{
University p = universityRepository.findById(1L).get();
p.setNbEnseigant(10);
universityRepository.save(p);
}
@Test
public void testDeleteUniversity()
{
	universityRepository.deleteById(1L);;
}
 
@Test
public void testListUniversoties()
{
List<University> prods = universityRepository.findAll();
for (University p : prods)
{
System.out.println(p);
}
}



@Test
public void testFindByNomUniversity()
{
Page<University> prods = universityService.getAllUniversityParPage(0,2);
System.out.println(prods.getSize());
System.out.println(prods.getTotalElements());
System.out.println(prods.getTotalPages());
prods.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (Produit p : prods)
{
System.out.println(p);
} */
}


}