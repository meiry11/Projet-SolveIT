package fr.solveit.service;

import fr.solveit.model.Matiere;
import fr.solveit.repository.IMatiereRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {
    @Autowired
    private IMatiereRepo iMatiereRepo;


    public List<Matiere> findAll(){
        return this.iMatiereRepo .findAll();
    }


    public Matiere findById(Integer id) {
        Optional<Matiere> optSession = this.iMatiereRepo.findById(id);
        if (optSession.isPresent()) {
            return optSession.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




    public Matiere create(Matiere newMatiere) {
        return this.iMatiereRepo.save(newMatiere);
    }


    public Matiere update(Matiere matiere) {
        if (! this.iMatiereRepo.existsById(matiere.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver la matiere a mettre à jour");
        }
        return this.iMatiereRepo.save(matiere);
    }


    public Matiere delete (Integer id) {
        if (! this.iMatiereRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver la Session à supprimer");
        }
        Matiere matiereDel = this.findById(id);
        this.iMatiereRepo.deleteById(id);
        if (this.iMatiereRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppressiion de la Session");
        }

        return matiereDel;
    }


}