package com.example.tp1.employedb.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.tp1.employedb.model.Employe;
import com.example.tp1.employedb.storage.EmployeStorage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;


@ApplicationScoped // equivalent de init qui est dans la servlet
@Named("employedao")
@Transactional// toute les methode vont demarer une transaction
public class EmployeDAO {
	@PersistenceContext(unitName = "employedbPersistenceUnit")
	private EntityManager em;
	public static final String EMPLOYE_DAO_KEY= "EMPLOYE_DAO";
	
	private int idSequence = 0;
	private EmployeStorage storage;


//	public EmployeDAO(EmployeStorage storage) {
//		this.storage=storage;
//	}
		
	public void create(String nom, String prenom, int salaire){
		//idSequence++;
		Employe e = new Employe();
		//e.setId(idSequence);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setSalaire(salaire);
		e.setDateEmbauche(Date.valueOf(LocalDate.now()));
		//this.storage.getEmployeList().add(e);
		em.persist(e);

	}
	
	public void updateSalaire(int id, int salaire) {
		Employe e = getEmployeById(id);
		e.setSalaire(salaire);
		em.merge(e);
		em.flush(); // comme un ramasse miette et par exeprience merge seul ne fait pas a jour
	}
	
	public void fire(int id) {
		Employe e = getEmployeById(id);
		e.setDateLicenciement(Date.valueOf(LocalDate.now()));
		em.merge(e);
		em.flush();
	}
	
	public Employe getEmployeById(int id) {
//		return this.storage.getEmployeList().stream()
//				.filter((e)->e.getId()==id)
//				.findAny()
//				.orElse(null);
		return  em.find(Employe.class,id);
	}
	
	public List<Employe> getHiredEmployes() {

//		return this.storage.getEmployeList().stream()
//				.filter((e)->e.getDateLicenciement()==null)
//				.collect(Collectors.toList());
		// CreateNativeQuery cest avec sql et avec JPQL c est le nom de classe au lieu de la table
		return em.createQuery("select employe from Employe employe where employe.dateLicenciement = null",Employe.class).getResultList();

	}
}
