package net.ict.campus.boesche.controller.controllers;

import net.ict.campus.boesche.controller.services.FraktionService;
import net.ict.campus.boesche.controller.services.FroescheService;
import net.ict.campus.boesche.model.models.Fraktion;
import net.ict.campus.boesche.model.models.Froesche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping ("/Fraktion")
public class FraktionController {
    private final FraktionService fraktionService;

    public FraktionController(FraktionService fraktionService) {
        this.fraktionService = fraktionService;
    }


    @GetMapping
    public Iterable<Fraktion> findAll(){
        try{ return fraktionService.findAll();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    private void insertFraktion(@Valid @RequestBody Fraktion fraktion) {
        try {
            fraktionService.insertFraktion(fraktion);
        } catch (RuntimeException r) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = "application/json")
    private void updateFraktion(@Valid @RequestBody Fraktion fraktion){
        try{
            fraktionService.updateFraktion(fraktion);
        }catch(RuntimeException r){
            throw new ResponseStatusException(HttpStatus.CONFLICT);


        }
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@RequestParam("Id") Integer id){
        try {
            fraktionService.deleteById(id);
        }catch(RuntimeException r){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    //Valid schaut ob der user import clean ist//


}


