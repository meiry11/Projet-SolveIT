package fr.solveit.service;



import fr.solveit.model.Departement;
import fr.solveit.model.Ville;
import fr.solveit.repository.IVilleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class VilleService {
    @Autowired
    private IVilleRepo iVilleRepo;

    /**
     * methode qui recupere du Repo les villes
     * @return List<Ville>
     */
    public List<Ville> findAll(){
        return this.iVilleRepo.findAll();
    }

    /**
     * methode qui permet de recuperer une Ville par son id
     * @param id Long, id de la Ville recherchée
     * @return Ville
     */
    public Ville findById(Integer id) {
        Optional<Ville> optVille = this.iVilleRepo.findById(id);
        if (optVille.isPresent()) {
            return optVille.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



    /**
     * methode qui permet d'enregistrer une Ville
     * @param newVille Ville, la Ville à enregistrer
     * @return Ville, la Ville enregistrée avec son id
     */
    public Ville create(Ville newVille) {
        return this.iVilleRepo.save(newVille);
    }

    /**
     * methode qui met a jour une Ville dans ma bdd
     * @param ville Ville, la Ville à mettre à jour
     * @return Ville, la Ville mise à jour
     */
    public Ville update(Ville ville) {
        if (! this.iVilleRepo.existsById(ville.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver la Ville à mettre à jour");
        }
        return this.iVilleRepo.save(ville);
    }

    /**
     * methode qui supprime une Ville de la bdd si elle y est
     * puis verifie si elle a bien été supprimée
     * @param id Long, id de la Ville à supprimer
     * @return Ville
     */
    public Ville delete (Integer id) {
        if (! this.iVilleRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver la Ville à supprimer");
        }
        Ville villeDel = this.findById(id);
        this.iVilleRepo.deleteById(id);
        if (this.iVilleRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppressiion de la Ville");
        }

        return villeDel;
    }

    public Ville findByLibelle(String libelle) {
        Ville optVille = this.iVilleRepo.findByLibelle(libelle);
        if (optVille != null ){
            return optVille;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
