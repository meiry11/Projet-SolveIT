package fr.solveit.controller;

import fr.solveit.model.Calendrier;
import fr.solveit.model.CalendrierId;
import fr.solveit.model.Compte;
import fr.solveit.service.CalendrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/calendriers")
public class CalendrierController {
    @Autowired
    private CalendrierService calendrierService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Calendrier> findAll() {return calendrierService.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public Calendrier findById(@PathVariable CalendrierId id) {
        return calendrierService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Calendrier create(@RequestBody Calendrier calendrier) {
        return calendrierService.create(calendrier);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Calendrier update(@RequestBody Calendrier calendrier,@PathVariable CalendrierId id) {
        if (!id.equals(calendrier.getCalendrierId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais Calendrier a mettre à jour");
        }
        return calendrierService.update(calendrier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Calendrier delete(@PathVariable CalendrierId id) {
        return calendrierService.delete(id);
    }
}
