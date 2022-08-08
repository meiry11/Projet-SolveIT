package fr.solveit.service;

import fr.solveit.model.Calendrier;
import fr.solveit.model.CalendrierId;
import fr.solveit.model.EmploiTemps;
import fr.solveit.model.EmploiTempsId;
import fr.solveit.repository.ICalendrierRepo;
import fr.solveit.repository.IEmploiTempsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmploiTempsService {
    @Autowired
    private IEmploiTempsRepo emploiTempsRepo;

    public List<EmploiTemps> findAll(){
        return emploiTempsRepo.findAll();
    }

    public EmploiTemps findById(EmploiTempsId id){
        Optional<EmploiTemps> optEmploiTemps = emploiTempsRepo.findById(id);
        if(optEmploiTemps.isPresent())
            return optEmploiTemps.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public EmploiTemps create(EmploiTemps emploiTemps ){
        return emploiTempsRepo.save(emploiTemps);
    }

    public EmploiTemps update(EmploiTemps emploiTemps){
        if(emploiTempsRepo.existsById(emploiTemps.getEmploiTempsId()))
            return emploiTempsRepo.save(emploiTemps);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public EmploiTemps delete(EmploiTempsId id){
        if (! emploiTempsRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }

        EmploiTemps optEmploiTemps = findById(id);

        emploiTempsRepo.delete(optEmploiTemps);
        return optEmploiTemps;
    }
}
