package fr.solveit.controller;
import fr.solveit.model.Pays;
import fr.solveit.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/Pays")
public class PaysController {
    @Autowired
    private PaysService paysService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Pays> findAll() {
        return this.paysService.findAll();
    }

    // Récuperation de l'id depuis l'adresse, et injection dans l'id en paramètre (Long id)
    @GetMapping ("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Pays findById(@PathVariable Integer id) {
        return this.paysService.findById(id);
    }

    @GetMapping("/libelle/{libelle}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Pays> findBylibelle(@PathVariable String libelle) {
        return this.paysService.findBylibelle(libelle);
    }


    //pas besoin de péciser plus, meme adresse que la "get" mais pas la meme methode ici en post
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Pays create (@RequestBody Pays newPays) {
        return this.paysService.create(newPays);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Pays update(@RequestBody Pays pays, @PathVariable Long id) {
        if (!id.equals(pays.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvais pays à mettre à jour");
        }
        return this.paysService.update(pays);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Pays delete (@PathVariable Integer id) {
        return this.paysService.delete(id);
    }


}
