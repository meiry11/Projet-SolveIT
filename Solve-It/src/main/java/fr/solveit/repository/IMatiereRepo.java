package fr.solveit.repository;

import fr.solveit.model.Matiere;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatiereRepo extends JpaRepository<Matiere, Integer> {
}
