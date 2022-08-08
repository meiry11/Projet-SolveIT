package fr.solveit.repository;

import fr.solveit.model.SituationProrfessionnelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISituationProfessionnelleRepo extends JpaRepository<SituationProrfessionnelle, Integer> {


}
