package fr.solveit.service;

import fr.solveit.model.Hebergement;
import fr.solveit.repository.IHebergementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class HebergementService {

    @Autowired
    private IHebergementRepo hebergementRepo;

    /**
     * methode qui recupere du Repo la liste des hebergement
     * @return List<Hebergement>
     */
    public List<Hebergement> findAll(){
        return this.hebergementRepo.findAll();
    }

    /**
     * methode qui permet de recuperer un hebergement par son id
     * @param id Long, id de l'hebergement recherchée
     * @return Hebergement
     */
    public Hebergement findById(Integer id) {
        Optional<Hebergement> opthebergement = this.hebergementRepo.findById(id);
        if (opthebergement.isPresent()) {
            return opthebergement.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * methode qui permet d'enregistrer un hebergement
     * @param newHebergement Hebergement, l'hebergement a enregistrée
     * @return Hebergement, l'hebergement enregistrée avec son id
     */
    public Hebergement create(Hebergement newHebergement) {
        return this.hebergementRepo.save(newHebergement);
    }

    /**
     * methode qui met a jour un hebergement dans ma bdd
     * @param hebergement Hebergement,l'hebergement a mettre à jour
     * @return Hebergement, l'hebergement mise à jour
     */
    public Hebergement update(Hebergement hebergement) {
        if (! this.hebergementRepo.existsById(hebergement.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'Adresse a mettre à jour");
        }
        return this.hebergementRepo.save(hebergement);
    }

    /**
     * methode qui supprime une Adresse de la bdd si elle y est
     * puis verifie si elle a bien été supprimée
     * @param id Long, id de l'Adresse à supprimer
     * @return Adresse
     */
    public Hebergement delete (Integer id) {
        if (! this.hebergementRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'Adresse à supprimer");
        }
        Hebergement hebergementDel = this.findById(id);
        this.hebergementRepo.deleteById(id);
        if (this.hebergementRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppressiion de l'Adresse");
        }
        return hebergementDel;
    }




}
