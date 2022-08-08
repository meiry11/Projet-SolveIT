package fr.solveit.controller;

import fr.solveit.model.Absence;
import fr.solveit.model.AbsenceId;

import fr.solveit.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/absences")
public class AbsenceController {
    @Autowired
    private AbsenceService absenceService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Absence> findAll() {return absenceService.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public Absence findById(@PathVariable AbsenceId id) {
        return absenceService.findById(id);
    }

    @GetMapping("/{numSec}")
    @ResponseStatus(code= HttpStatus.OK)
    public List<Absence> findByStagiaire(@PathVariable String numSec) {
        return absenceService.findByStagiaire(numSec);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Absence create(@RequestBody Absence absence) {
        return absenceService.create(absence);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Absence update(@RequestBody Absence absence,@PathVariable AbsenceId id) {
        if (!id.equals(absence.getAbsenceId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais Absence a mettre à jour");
        }
        return absenceService.update(absence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Absence delete(@PathVariable AbsenceId id) {
        return absenceService.delete(id);
    }
}
