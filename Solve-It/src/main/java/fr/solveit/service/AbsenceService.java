package fr.solveit.service;


import fr.solveit.model.Absence;
import fr.solveit.model.AbsenceId;
import fr.solveit.model.Stagiaire;
import fr.solveit.repository.IAbsenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {
    @Autowired
    private IAbsenceRepo absenceRepo;

    public List<Absence> findAll(){
        return absenceRepo.findAll();
    }
    public List<Absence> findByStagiaire( String numSecu){
        return findByStagiaire(numSecu);
    }
    public Absence findById(AbsenceId id){
        Optional<Absence> optabsence = absenceRepo.findById(id);
        if(optabsence.isPresent())
            return optabsence.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Absence create(Absence absence ){
        return absenceRepo.save(absence );
    }

    public Absence update(Absence absence){
        if(absenceRepo.existsById(absence.getAbsenceId()))
            return absenceRepo.save(absence);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Absence delete(AbsenceId id){
        if (! absenceRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Absence optabsence = findById(id);

        absenceRepo.delete(optabsence);
        return optabsence;
    }
}
