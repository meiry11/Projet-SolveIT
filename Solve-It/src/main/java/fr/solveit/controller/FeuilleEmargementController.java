package fr.solveit.controller;

import fr.solveit.model.EmploiTemps;
import fr.solveit.model.EmploiTempsId;
import fr.solveit.model.FeuilleEmargement;
import fr.solveit.service.FeuilleEmargementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/feuilleemargements")
public class FeuilleEmargementController {
    @Autowired
    private FeuilleEmargementService feuilleEmargementService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<FeuilleEmargement> findAll() {return feuilleEmargementService.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public FeuilleEmargement findById(@PathVariable String id) {
        return feuilleEmargementService.findById(id);
    }

    @GetMapping("/{date}")
    @ResponseStatus(code= HttpStatus.OK)
    public List<FeuilleEmargement> findAllByDateDebutFormation(@PathVariable java.sql.Date date) {
        return feuilleEmargementService.findAllByDateDebutFormation(date);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public FeuilleEmargement create(@RequestBody FeuilleEmargement feuilleEmargement) {
        return feuilleEmargementService.create(feuilleEmargement);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public FeuilleEmargement update(@RequestBody FeuilleEmargement feuilleEmargement,@PathVariable String id) {
        if (!id.equals(feuilleEmargement.getNum())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais Absence a mettre à jour");
        }
        return feuilleEmargementService.update(feuilleEmargement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public FeuilleEmargement delete(@PathVariable String id) {
        return feuilleEmargementService.delete(id);
    }
}
