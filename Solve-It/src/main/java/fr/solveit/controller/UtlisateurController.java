package fr.solveit.controller;

import fr.solveit.model.*;
import fr.solveit.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/utilisateurs")
public class UtlisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/formateurs")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Formateur> findAllFormateur(){
        return utilisateurService.findAllFormateur();
    }
    @GetMapping("/stagiaires")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Stagiaire> findAllStagiaire(){
        return utilisateurService.findAllStagiaire();
    }
    @GetMapping("/administration")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Administration> findAllAdministration(){
        return utilisateurService.findAllAdministration();
    }
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Utilisateur> findAll() {return utilisateurService.findAll();}
    @GetMapping("/{numsecu}")
    @ResponseStatus(code= HttpStatus.OK)
    public Utilisateur findById(@PathVariable String numsecu) {
        return utilisateurService.findById(numsecu);
    }
    @GetMapping("/stagiaires/{date}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Stagiaire> findByAbsence(@PathVariable Date date){ return utilisateurService.findByAbsence(date);}

    @GetMapping("/stagiaires/{lib}/{date_debut}/{date_fin}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Stagiaire> findBySession(@PathVariable("lib") String lib,@PathVariable(name = "date_debut")  Date date_debut,@PathVariable(name = "date_fin") Date date_fin){ return utilisateurService.findBySession(lib,date_debut,date_fin);}

    @PostMapping(value = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {

        System.out.println("objet");
        return utilisateurService.create(utilisateur);
    }

    @PostMapping("/{numsecu}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Utilisateur update(@RequestBody Utilisateur utilisateur,@PathVariable String numsecu) {
        if (!numsecu.equals(utilisateur.getNumSecu())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais compte a mettre à jour");
        }
        return utilisateurService.update(utilisateur);
    }

    @DeleteMapping("/{numsecu}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Utilisateur delete(@PathVariable String numsecu) {

        return utilisateurService.delete(numsecu);
    }
}
