package fr.solveit.repository;


import fr.solveit.model.Absence;
import fr.solveit.model.AbsenceId;
import fr.solveit.model.Stagiaire;
import fr.solveit.model.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.solveit.model.Absence;
import fr.solveit.model.AbsenceId;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAbsenceRepo extends JpaRepository<Absence, AbsenceId> {

    @Query("select a from Absence a left join a.absenceId.stagiaire se where se.numSecu = :numSecu")
    List<Absence> findByStagiaire(@Param("numSecu") String numSecu);

}
