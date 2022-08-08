package com.example.tp1.employedb.storage;

import java.util.ArrayList;
import java.util.List;

import com.example.tp1.employedb.model.Employe;
/**
 * Cette classe gère la liste d'employés
 */
public class EmployeStorage {
	public static final String EMPLOYE_STORAGE_KEY = "employeList";
	
	private List<Employe> employeList = new ArrayList<Employe>();
	
	public List<Employe> getEmployeList(){
		return employeList;
	}
}
