package fr.solveit.repository;

import fr.solveit.model.FeuilleEmargement;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IFeuilleEmargementRepo extends JpaRepository<FeuilleEmargement, String> {

    @Query("select f from FeuilleEmargement f where f.date_debut_formation = :date")
    List<FeuilleEmargement> findAllByDateDebutFormation(@Param("date") java.sql.Date date);

}
