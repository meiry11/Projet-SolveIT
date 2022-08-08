package aston.springini.controller;

import aston.springini.entity.Guitare;
import aston.springini.service.GuitareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Class Controller pour les entitées guitare
 * @author roumaissa
 */
@RestController
@RequestMapping("/guitares")
public class GuitareController {
    @Autowired   // injection de dependance par class ca remplace new / factory / Bean / xml et classe
    private GuitareService guitareService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Guitare> findAll(){
        return guitareService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Guitare findById(@PathVariable Long id){
        return guitareService.findById(id);
    }

    @GetMapping("/model/{model}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Guitare> findByModel(@PathVariable String model){
        return guitareService.findByModel(model);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Guitare create(@RequestBody Guitare guitare){
        return guitareService.create(guitare);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Guitare update(@RequestBody Guitare guitare,@PathVariable Long id){
        if(!(id==guitare.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"une mauvaise guitare a mettre a jour");
        return guitareService.update(guitare);

    }

    @DeleteMapping("")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Guitare delete(Long id){
        return guitareService.delete(id);
    }
}
