package com.nour.university.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class University {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idUniversity;
private String nomUiversity;
private String villeUniversity;
private int nbEnseigant;
private Date creationDate;


public University() {
super();
}


public University( String nomUiversity, String villeUniversity, int nbEnseigant, Date creationDate) {
	super();
	
	this.nomUiversity = nomUiversity;
	this.villeUniversity = villeUniversity;
	this.nbEnseigant = nbEnseigant;
	this.creationDate = creationDate;
}


public Long getIdUniversity() {
	return idUniversity;
}


public void setIdUniversity(Long idUniversity) {
	this.idUniversity = idUniversity;
}


public String getNomUiversity() {
	return nomUiversity;
}


public void setNomUiversity(String nomUiversity) {
	this.nomUiversity = nomUiversity;
}


public String getVilleUniversity() {
	return villeUniversity;
}


public void setVilleUniversity(String villeUniversity) {
	this.villeUniversity = villeUniversity;
}


public int getNbEnseigant() {
	return nbEnseigant;
}


public void setNbEnseigant(int nbEnseigant) {
	this.nbEnseigant = nbEnseigant;
}


public Date getCreationDate() {
	return creationDate;
}


public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
}


@Override
public String toString() {
	return "University [idUniversity=" + idUniversity + ", nomUiversity=" + nomUiversity + ", villeUniversity="
			+ villeUniversity + ", nbEnseigant=" + nbEnseigant + ", creationDate=" + creationDate + "]";
}



}






