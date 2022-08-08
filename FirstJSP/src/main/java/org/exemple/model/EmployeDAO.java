package org.exemple.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeDAO {
    private int i=0;
    private EmployeStorage storage;

    public EmployeDAO(EmployeStorage storage){
        this.storage = storage;
    }

    public void create(String nom , String prenom, int salaire) {
        Employe e = new Employe();
        e.setNom(nom);
        e.setPrénom(prenom);
        e.setSalaire(salaire);
        e.setDateEmbauche(Date.valueOf(LocalDate.now()));
        i++;
        e.setId(i);
        storage.getEmployees().add(e);
    }

    public Employe getEmployeById(int id){
        return storage.getEmployees().stream().filter(e-> e.getId() == id).findAny().orElse(null);
    }

    public void updateSalaire(int id,int salaire){
        Employe e = getEmployeById(id);
        e.setSalaire(salaire);
    }

    public void fireEmploye(int id){
        Employe e = getEmployeById(id);
        e.setDate_licenciement(Date.valueOf(LocalDate.now()));
    }

    public List<Employe> getHiredEmploye(){
        return storage.getEmployees().stream().filter(e-> e.getDate_licenciement() == null).collect(Collectors.toList());
    }
}
