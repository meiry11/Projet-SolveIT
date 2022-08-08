package fr.solveit.repository;

import fr.solveit.model.Compte;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompteRepo extends JpaRepository<Compte, Integer> {
}
