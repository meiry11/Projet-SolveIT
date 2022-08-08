package fr.solveit.service;

import fr.solveit.model.Session;
import fr.solveit.model.Session;
import fr.solveit.repository.ISessionRepo;
import fr.solveit.repository.ISessionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class SessionService {
    @Autowired
    private ISessionRepo iSessionRepo;

    /**
     * methode qui recupere du Repo les Sessions
     * @return List<Session>
     */
    public List<Session> findAll(){
        return this.iSessionRepo.findAll();
    }

    /**
     * methode qui permet de recuperer une Session par son id
     * @param id Long, id de la Session recherchée
     * @return Session
     */
    public Session findById(Integer id) {
        Optional<Session> optSession = this.iSessionRepo.findById(id);
        if (optSession.isPresent()) {
            return optSession.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }



    /**
     * methode qui permet d'enregistrer une Session
     * @param newSession Session, la Session a enregistrée
     * @return Session, la Session enregistrée avec son id
     */
    public Session create(Session newSession) {
        return this.iSessionRepo.save(newSession);
    }

    /**
     * methode qui met a jour une Session dans ma bdd
     * @param session Session, la Session a mettre à jour
     * @return Session, la Session mise à jour
     */
    public Session update(Session session) {
        if (! this.iSessionRepo.existsById(session.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
                    "impossible de trouver la Session a mettre à jour");
        }
        return this.iSessionRepo.save(session);
    }

    /**
     * methode qui supprime une Session de la bdd si elle y est
     * puis verifie si elle a bien été supprimée
     * @param id Long, id de la Session à supprimer
     * @return Session
     */
    public Session delete (Integer id) {
        if (! this.iSessionRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver la Session à supprimer");
        }
        Session sessionDel = this.findById(id);
        this.iSessionRepo.deleteById(id);
        if (this.iSessionRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "erreur lors de la suppressiion de la Session");
        }

        return sessionDel;
    }

}