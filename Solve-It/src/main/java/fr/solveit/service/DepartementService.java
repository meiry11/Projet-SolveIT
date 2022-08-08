package fr.solveit.service;

import fr.solveit.model.Departement;
import fr.solveit.model.Stagiaire;
import fr.solveit.repository.IDepartementRepo;
import fr.solveit.repository.IUtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;


import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private IDepartementRepo iDepartementRepo;

    /**
     * methode qui recupere du Repo les departements
     * @return List<Departement>
     */
    public List<Departement> findAll(){
        return this.iDepartementRepo.findAll();
    }

    /**
     * methode qui permet de recuperer un Departement par son
     * @param id Long, id du Departement recherché
     * @return Departement
     */
    public Departement findById(Integer id) {
        Optional<Departement> optDepartement = this.iDepartementRepo.findById(id);
        if (optDepartement.isPresent()) {
            return optDepartement.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public Departement findByLibelle(String libelle) {
        Departement optDepartement = this.iDepartementRepo.findByLibelle(libelle);
    if (optDepartement != null ){
                return optDepartement;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
    }

//    public List<Departement> findByLibelle(String libelle){
//        List<Departement> optDepartement = iDepartementRepo.findByLibelle(libelle);
//        if(optDepartement != null)
//            return optDepartement;
//        else
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//    }




    /**
     * methode qui permet d'enregistrer un Departement
     * @param newDepartement Departement, le Departement à enregistrer
     * @return Departement, le Departement enregistré avec son id
     */
    public Departement create(Departement newDepartement) {
        return this.iDepartementRepo.save(newDepartement);
    }

    /**
     * methode qui met a jour un Departement dans ma bdd
     * @param departement Departement, le Departement à mettre à jour
     * @return Departement, le Departement mise à jour
     */
    public Departement update(Departement departement) {
        if (! this.iDepartementRepo.existsById(departement.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver le Departement à mettre à jour");
        }
        return this.iDepartementRepo.save(departement);
    }

    /**
     * methode qui supprime un Departement de la bdd si elle y est
     * puis verifie si il a bien été supprimé
     * @param id Long, id de le Departement à supprimer
     * @return Departement
     */
    public Departement delete (Integer id) {
        if (! this.iDepartementRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver la Ville à supprimer");
        }
        Departement departementDel = this.findById(id);
        this.iDepartementRepo.deleteById(id);
        if (this.iDepartementRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppressiion de le Departement");
        }

        return departementDel;
    }

}
