package fr.solveit.repository;

import fr.solveit.model.Hebergement;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHebergementRepo extends JpaRepository<Hebergement, Integer> {
}
