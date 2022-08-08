package fr.solveit.controller;


import fr.solveit.model.SituationProrfessionnelle;
import fr.solveit.service.SituationProfessionnelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/situation")
public class SituationProfessionnelleController {

    @Autowired
    private SituationProfessionnelleService situationProfessionnelleService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<SituationProrfessionnelle> findAll() {return this.situationProfessionnelleService.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public SituationProrfessionnelle findById(@PathVariable Integer id) {
        return this.situationProfessionnelleService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public SituationProrfessionnelle create(@RequestBody SituationProrfessionnelle newSituationPro) {
        return this.situationProfessionnelleService.create(newSituationPro);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public SituationProrfessionnelle update(@RequestBody SituationProrfessionnelle situationProrfessionnelle,@PathVariable Integer id) {
        if (!id.equals(situationProrfessionnelle.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvaise Adress a mettre à jour");
        }
        return this.situationProfessionnelleService.update(situationProrfessionnelle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public SituationProrfessionnelle delete(@PathVariable Integer id) {
        return this.situationProfessionnelleService.delete(id);
    }


}
