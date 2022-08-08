package fr.solveit.controller;


import fr.solveit.model.Departement;
import fr.solveit.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Departement")
public class DepartementController {


    @Autowired
    private DepartementService departementService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Departement> findAll() {
        return this.departementService.findAll();
    }

    // Récuperation de l'id depuis l'adresse, et injection dans l'id en paramètre (Long id)
    @GetMapping ("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Departement findById(@PathVariable Integer id) {
        return this.departementService.findById(id);
    }

    @GetMapping("/libelle/{libelle}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Departement> findBylibelle(@PathVariable String libelle) {

        return (List<Departement>) this.departementService.findByLibelle(libelle);

    }


    //pas besoin de péciser plus, meme adresse que la "get" mais pas la meme methode ici en post
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Departement create (@RequestBody Departement newDepartement) {
        return this.departementService.create(newDepartement);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Departement update(@RequestBody Departement departement, @PathVariable Long id) {
        if (!id.equals(departement.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvais departement à mettre à jour");
        }
        return this.departementService.update(departement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Departement delete (@PathVariable Integer id) {
        return this.departementService.delete(id);
    }

}
