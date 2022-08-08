package fr.solveit.controller;

import fr.solveit.model.Ville;
import fr.solveit.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/villes")
public class VilleController {
    @Autowired
    private VilleService villeService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Ville> findAll() {
        return this.villeService.findAll();
    }

    // Récuperation de l'id depuis l'adresse, et injection dans l'id en paramètre (Long id)
    @GetMapping ("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Ville findById(@PathVariable Integer id) {
        return this.villeService.findById(id);
    }
/*
    @GetMapping("/libelle/{libelle}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Ville> findBylibelle(@PathVariable String libelle) {
        return this.villeService.findBylibelle(libelle);
    }
*/

    //pas besoin de péciser plus, meme adresse que la "get" mais pas la meme methode ici en post
    @PostMapping("") // dans le corps de la requete il y a un model d'objet de type guitare en Json pour créer l'objet
    @ResponseStatus(code = HttpStatus.CREATED)
    public Ville create (@RequestBody Ville newVille) {
        return this.villeService.create(newVille);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Ville update(@RequestBody Ville ville, @PathVariable Long id) {
        if (!id.equals(ville.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvaise ville à mettre à jour");
        }
        return this.villeService.update(ville);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Ville delete (@PathVariable Integer id) {
        return this.villeService.delete(id);
    }


}

