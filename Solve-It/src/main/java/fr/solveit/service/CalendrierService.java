package fr.solveit.service;

import fr.solveit.model.Calendrier;
import fr.solveit.model.CalendrierId;
import fr.solveit.repository.ICalendrierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CalendrierService {
    @Autowired
    private ICalendrierRepo calendrierRepo;

    public List<Calendrier> findAll(){
        return calendrierRepo.findAll();
    }

    public Calendrier findById(CalendrierId id){
        Optional<Calendrier> optcalendrier = calendrierRepo.findById(id);
        if(optcalendrier.isPresent())
            return optcalendrier.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Calendrier create(Calendrier calendrier ){
        return calendrierRepo.save(calendrier );
    }

    public Calendrier update(Calendrier calendrier){
        if(calendrierRepo.existsById(calendrier.getCalendrierId()))
            return calendrierRepo.save(calendrier);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public Calendrier delete(CalendrierId id){
        if (! calendrierRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        Calendrier optcalendrier = findById(id);

        calendrierRepo.delete(optcalendrier);
        return optcalendrier;
    }
}
