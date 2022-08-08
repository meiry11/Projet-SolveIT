package fr.solveit.controller;



import fr.solveit.model.Hebergement;
import fr.solveit.service.HebergementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/hebergement")
public class HebergementController {

    @Autowired
    private HebergementService hebergementService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Hebergement> findAll() { return hebergementService.findAll();}


    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Hebergement findById(@PathVariable Integer id){ return this.hebergementService.findById(id);}


    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Hebergement create(@RequestBody Hebergement hebergement) { return this.hebergementService.create(hebergement);}

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Hebergement update(@RequestBody Hebergement hebergement, @PathVariable Integer id) {
        if (!id.equals(hebergement.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Mauvais hébergment mis à jour");
        }
        return this.hebergementService.update(hebergement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Hebergement delete(@PathVariable Integer id) { return this.hebergementService.delete(id);}


}
