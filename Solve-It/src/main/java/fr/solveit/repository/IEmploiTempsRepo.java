package fr.solveit.repository;

import fr.solveit.model.EmploiTemps;
import fr.solveit.model.EmploiTempsId;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmploiTempsRepo extends JpaRepository<EmploiTemps, EmploiTempsId> {
}
