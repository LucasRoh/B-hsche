package net.ict.campus.boesche.controller.controllers;

import net.ict.campus.boesche.controller.services.FroescheService;
import net.ict.campus.boesche.model.models.Froesche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping ("/Froesche")
public class FroescheController {
    private final FroescheService froescheService;

    @Autowired
    public FroescheController(FroescheService froescheService) {
        this.froescheService = froescheService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<Froesche> findAll(){
        try{ return froescheService.findall();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    private void insertFroesche(@Valid @RequestBody Froesche froesche) {
        try {
            FroescheService.insertFroesche(froesche);
        } catch (RuntimeException r) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = "application/json")
    private void updateFroesche(@Valid @RequestBody Froesche froesche){
            try{
                FroescheService.updateFroesche(froesche);
            }catch(RuntimeException r){
                throw new ResponseStatusException(HttpStatus.CONFLICT);


            }
        }
        @DeleteMapping
        @ResponseStatus(HttpStatus.ACCEPTED)
        public void deleteById(@RequestParam("Id") Integer id){
        try {
            FroescheService.deleteById(id);
        }catch(RuntimeException r){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
        //Valid schaut ob der user import clean ist//


}
