package fr.solveit.service;

import fr.solveit.model.Pays;
import fr.solveit.model.Ville;
import fr.solveit.repository.IPaysRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PaysService {
    @Autowired
    private IPaysRepo iPaysRepo;

    /**
     * methode qui recupere du Repo des Pays
     * @return List<Pays>
     */
    public List<Pays> findAll(){
        return this.iPaysRepo.findAll();
    }

    /**
     * methode qui permet de recuperer un Pays par son id
     * @param id Long, id de le Pays recherché
     * @return Pays
     */
    public Pays findById(Integer id) {
        Optional<Pays> optPays = this.iPaysRepo.findById(id);
        if (optPays.isPresent()) {
            return optPays.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



    /**
     * methode qui permet d'enregistrer un Pays
     * @param newPays Pays, la Pays à enregistrer
     * @return Pays, le Pays enregistré avec son id
     */
    public Pays create(Pays newPays) {
        return this.iPaysRepo.save(newPays);
    }

    /**
     * methode qui met a jour une Ville dans ma bdd
     * @param pays Ville, la Ville à mettre à jour
     * @return Ville, la Ville mise à jour
     */
    public Pays update(Pays pays) {
        if (! this.iPaysRepo.existsById(pays.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le Pays à mettre à jour");
        }
        return this.iPaysRepo.save(pays);
    }

    /**
     * methode qui supprime un Pays de la bdd si elle y est
     * puis verifie si il a bien été supprimé
     * @param id Long, id de le Pays à supprimer
     * @return Pays
     */
    public Pays delete (Integer id) {
        if (! this.iPaysRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver le Pays à supprimer");
        }
        Pays paysDel = this.findById(id);
        this.iPaysRepo.deleteById(id);
        if (this.iPaysRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppressiion de le Pays");
        }
        return paysDel;
    }




    public List<Pays> findBylibelle(String libelle) {
        Pays optPays = this.iPaysRepo.findByLibelle(libelle);
        if (optPays != null ){
            return (List<Pays>) optPays;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}


