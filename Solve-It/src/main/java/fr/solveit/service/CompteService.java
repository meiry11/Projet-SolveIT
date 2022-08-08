package fr.solveit.service;

import fr.solveit.model.Compte;
import fr.solveit.repository.ICompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {
    @Autowired
    private ICompteRepo compteRepo;

    public List<Compte> findAll(){
        return compteRepo.findAll();
    }

    public Compte findById(Integer id){
        Optional<Compte> optcompte = compteRepo.findById(id);
        if(optcompte.isPresent())
            return optcompte.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Compte create(Compte compte ){
        return compteRepo.save(compte );
    }

    public Compte update(Compte compte){
        if(compteRepo.existsById(compte.getId()))
            return compteRepo.save(compte);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver le compte a mettre a jour");
    }

    public Compte delete(Integer id){
        if (! compteRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }

        Compte optcompte = findById(id);

        compteRepo.delete(optcompte);
        return optcompte;
    }
}
