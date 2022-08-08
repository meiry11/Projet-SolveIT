package fr.solveit.controller;

import fr.solveit.model.Session;
import fr.solveit.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/session")

public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("")
    @ResponseStatus(code= HttpStatus.OK)
    public List<Session> findAll(){
        return this.sessionService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public Session findById(@PathVariable Integer id){
        return  this.sessionService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Session create (@RequestBody Session newSession){

        return this.sessionService.create(newSession);
    }

    @PostMapping("/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public Session update (@RequestBody Session Session,@PathVariable Integer id){
        if (!id.equals(Session.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"mauvaise Session a mettre a jour");
        }
        return this.sessionService.update(Session);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public Session delete (@PathVariable Integer id){

        return this.sessionService.delete(id);
    }
}
