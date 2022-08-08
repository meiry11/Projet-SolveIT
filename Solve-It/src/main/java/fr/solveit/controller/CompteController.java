package fr.solveit.controller;

import fr.solveit.model.Compte;
import fr.solveit.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/comptes")
public class CompteController {
    @Autowired
    private CompteService compteService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Compte> findAll() {
        System.out.println("------> ok");
        return compteService.findAll();}

    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public Compte findById(@PathVariable Integer id) {
        return compteService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Compte create(@RequestBody Compte compte) {
        return compteService.create(compte);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Compte update(@RequestBody Compte compte,@PathVariable Integer id) {
        if (!id.equals(compte.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "mauvais compte a mettre à jour");
        }
        return compteService.update(compte);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Compte delete(@PathVariable Integer id) {
        return compteService.delete(id);
    }
}
