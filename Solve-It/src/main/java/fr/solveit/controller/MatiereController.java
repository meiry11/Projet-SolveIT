package fr.solveit.controller;

import fr.solveit.model.Matiere;
import fr.solveit.model.Session;
import fr.solveit.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/matiere")

public class MatiereController {
    

        @Autowired
        private MatiereService matiereService;

        @GetMapping("")
        @ResponseStatus(code= HttpStatus.OK)
        public List<Matiere> findAll(){
            return this.matiereService.findAll();
        }
        @GetMapping("/{id}")
        @ResponseStatus(code= HttpStatus.OK)
        public Matiere findById(@PathVariable Integer id){
            return  this.matiereService.findById(id);
        }

        @PostMapping("")
        @ResponseStatus(code= HttpStatus.CREATED)
        public Matiere create (@RequestBody Matiere newMatiere){

            return this.matiereService.create(newMatiere);
        }

        @PostMapping("/{id}")
        @ResponseStatus(code= HttpStatus.ACCEPTED)
        public Matiere update (@RequestBody Matiere matiere,@PathVariable Integer id){
            if (!id.equals(matiere.getId())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"mauvaise matiere a mettre a jour");
            }
            return this.matiereService.update(matiere);
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(code= HttpStatus.ACCEPTED)
        public Matiere delete (@PathVariable Integer id){

            return this.matiereService.delete(id);
        }
    }


