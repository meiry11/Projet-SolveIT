package fr.solveit.repository;

import fr.solveit.model.Pays;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaysRepo extends JpaRepository<Pays, Integer> {
    public Pays findByLibelle(String libelle);
}
