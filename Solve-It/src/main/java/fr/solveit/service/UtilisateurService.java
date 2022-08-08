package fr.solveit.service;

import fr.solveit.model.Administration;
import fr.solveit.model.Formateur;
import fr.solveit.model.Stagiaire;
import fr.solveit.model.Utilisateur;
import fr.solveit.repository.IUtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {


    @Autowired
    private IUtilisateurRepo utilisateurRepo;

    public List<Formateur> findAllFormateur(){
        return utilisateurRepo.findAllFormateur();
    }
    public List<Stagiaire> findAllStagiaire(){
        return utilisateurRepo.findAllStagiaire();
    }
    public List<Administration> findAllAdministration(){
        return utilisateurRepo.findAllAdministration();
    }
    public List<Utilisateur> findAll(){
        return utilisateurRepo.findAll();
    }
    public Utilisateur findById(String numSecu){
        Optional<Utilisateur> optutilisateur= utilisateurRepo.findById(numSecu);
        if(optutilisateur.isPresent())
            return optutilisateur.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    public List<Stagiaire> findByAbsence(Date date){
        List<Stagiaire> optStagiaire= utilisateurRepo.findByAbsence(date);
        if(optStagiaire != null)
            return optStagiaire;
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Stagiaire> findBySession(String lib, Date date_debut,Date date_fin){
        List<Stagiaire> optStagiaire= utilisateurRepo.findBySession(lib,date_debut,date_fin);
        if(optStagiaire != null)
            return optStagiaire;
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    public Utilisateur create(Utilisateur utilisateur ){
        return utilisateurRepo.save(utilisateur );
    }

    public Utilisateur update(Utilisateur utilisateur){
        if(utilisateurRepo.existsById(utilisateur.getNumSecu()))
            return utilisateurRepo.save(utilisateur);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver le compte a mettre a jour");
    }

    public Utilisateur delete(String id){
        if (! utilisateurRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'objet à supprimer");
        }

        Utilisateur optutilisateur = findById(id);

        utilisateurRepo.delete(optutilisateur);
        return optutilisateur;
    }

}
