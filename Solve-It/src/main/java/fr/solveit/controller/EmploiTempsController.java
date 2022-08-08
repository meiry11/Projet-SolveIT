package fr.solveit.controller;

import fr.solveit.model.Absence;
import fr.solveit.model.AbsenceId;
import fr.solveit.model.EmploiTemps;
import fr.solveit.model.EmploiTempsId;
import fr.solveit.service.EmploiTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/emploitemps")
public class EmploiTempsController {
    @Autowired
    private EmploiTempsService emploiTempsService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<EmploiTemps> findAll() {return emploiTempsService.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public EmploiTemps findById(@PathVariable EmploiTempsId id) {
        return emploiTempsService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmploiTemps create(@RequestBody EmploiTemps emploiTemps) {
        return emploiTempsService.create(emploiTemps);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public EmploiTemps update(@RequestBody EmploiTemps emploiTemps,@PathVariable EmploiTempsId id) {
        if (!id.equals(emploiTemps.getEmploiTempsId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais Absence a mettre à jour");
        }
        return emploiTempsService.update(emploiTemps);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public EmploiTemps delete(@PathVariable EmploiTempsId id) {
        return emploiTempsService.delete(id);
    }
}
