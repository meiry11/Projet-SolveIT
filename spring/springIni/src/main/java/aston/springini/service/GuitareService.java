package aston.springini.service;

import aston.springini.entity.Guitare;
import aston.springini.repository.IGuitareRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * classe de service pour les entitées guitare
 * @author roumaissa
 */
@Service
public class GuitareService {
    @Autowired
    private IGuitareRepo guitareRepo;

    public List<Guitare> findAll(){
        return guitareRepo.findAll();
    }

    public Guitare findById(Long id){
        Optional<Guitare> optguitare = guitareRepo.findById(id);
        if(optguitare.isPresent())
            return optguitare.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public List<Guitare> findByModel(String model){
        return guitareRepo.findByModel(model);
    }

    public Guitare create(Guitare guitare){
        return guitareRepo.save(guitare);
    }

    public Guitare update(Guitare guitare){
        if(guitareRepo.existsById(guitare.getId()))
            return guitareRepo.save(guitare);
        else
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"impossible de trouver la guitare a mettre a jour");
    }

    public Guitare delete(Long id){
        Guitare optguitare = findById(id);

        guitareRepo.delete(optguitare);
        return optguitare;
    }


}
