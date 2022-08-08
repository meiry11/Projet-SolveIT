package fr.solveit.service;

import fr.solveit.model.Compte;
import fr.solveit.model.FeuilleEmargement;
import fr.solveit.repository.ICompteRepo;
import fr.solveit.repository.IFeuilleEmargementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FeuilleEmargementService {
    @Autowired
    private IFeuilleEmargementRepo feuilleEmargementRepo;

    public List<FeuilleEmargement> findAll(){
        return feuilleEmargementRepo.findAll();
    }

    public FeuilleEmargement findById(String id){
        Optional<FeuilleEmargement> optFeuilleEmargement = feuilleEmargementRepo.findById(id);
        if(optFeuilleEmargement.isPresent())
            return optFeuilleEmargement.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<FeuilleEmargement> findAllByDateDebutFormation(java.sql.Date date){
        FeuilleEmargement optFeuilleEmargement = (FeuilleEmargement) feuilleEmargementRepo.findAllByDateDebutFormation(date);
        if(optFeuilleEmargement != null )
            return (List<FeuilleEmargement>) optFeuilleEmargement;
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public FeuilleEmargement create(FeuilleEmargement feuilleEmargement ){
        return feuilleEmargementRepo.save(feuilleEmargement );
    }

    public FeuilleEmargement update(FeuilleEmargement feuilleEmargement){
        if(feuilleEmargementRepo.existsById(feuilleEmargement.getNum()))
            return feuilleEmargementRepo.save(feuilleEmargement);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver l objet a mettre a jour");
    }

    public FeuilleEmargement delete(String id){

        if (! feuilleEmargementRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }
        FeuilleEmargement optfeuilleEmargement = findById(id);
        feuilleEmargementRepo.delete(optfeuilleEmargement);
        return optfeuilleEmargement;
    }
}
