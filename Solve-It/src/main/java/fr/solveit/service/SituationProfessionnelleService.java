package fr.solveit.service;

import fr.solveit.model.SituationProrfessionnelle;
import fr.solveit.repository.ISituationProfessionnelleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SituationProfessionnelleService {

    @Autowired
    private ISituationProfessionnelleRepo situationProfessionnelleRepo;

    /**
     * methode qui recupere du Repo toute les situations professionnelles
     * @return List<SituationProrfessionnelle>
     */
    public List<SituationProrfessionnelle> findAll(){
        return this.situationProfessionnelleRepo.findAll();
    }


    /**
     * methode qui permet de recupérer une situation professionnelle par son Id
     * @param id Integer, id de la situation professionnelle
     * @return situation professionnelle
     */
     public SituationProrfessionnelle findById(Integer id) {
        Optional<SituationProrfessionnelle> optSituationPro = this.situationProfessionnelleRepo.findById(id);
        if (optSituationPro.isPresent()) {
            return optSituationPro.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Methode qui permet d'enregistrer une situation
     * @param newSituation SituationProfessionnelle, la nouvelle situation pro enregistrée
     * @return SituationProfessionnelle, la situation enregistrée avec son id
     */
    public SituationProrfessionnelle create(SituationProrfessionnelle newSituation) {
         return this.situationProfessionnelleRepo.save(newSituation);
    }

    /**
     * methode qui met a jour une situation professionnelle dans ma bdd
     * @param situationPro SituationProrfessionnelle, la situation Pro a mettre à jour
     * @return SituationProrfessionnelle, la situation pro mis à jour
     */
    public SituationProrfessionnelle update(SituationProrfessionnelle situationPro) {
        if (! this.situationProfessionnelleRepo.existsById(situationPro.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver l'Adresse a mettre à jour");
        }
        return this.situationProfessionnelleRepo.save(situationPro);
    }

    /**
     * methode qui supprime une situation professionnelle da la Bdd seulemeent
     * si elle y est, puis verifie si elle a bien été supprimée
     * @param id Integer, id de la situation pro à supprimer
     * @return situationProDel qui a été supprimé
     */
        public SituationProrfessionnelle delete (Integer id) {
            if(! this.situationProfessionnelleRepo.existsById(id)){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "impossible de trouver la situation professionnelle à supprimer");
        }
        SituationProrfessionnelle situationProDel = this.findById(id);
        this.situationProfessionnelleRepo.deleteById(id);
        if (this.situationProfessionnelleRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppressiion de la situation professionnelle");
            }
                return situationProDel;
            }
        }



