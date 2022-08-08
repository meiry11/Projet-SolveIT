package fr.solveit.repository;

import fr.solveit.model.Departement;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartementRepo extends JpaRepository<Departement, Integer> {
    public Departement findByLibelle(String libelle);
}
