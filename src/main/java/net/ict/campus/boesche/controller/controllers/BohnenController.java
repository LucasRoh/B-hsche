package net.ict.campus.boesche.controller.controllers;

import net.ict.campus.boesche.controller.services.BohnenService;
import net.ict.campus.boesche.model.models.Bohnen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/ability")
public class BohnenController {
    //Bohnenservice wird aufgerufen um auf die Methoden zuzugreifen
    private final BohnenService bohnenService;

    @Autowired
    public BohnenController(BohnenService bohnenService) {
        this.bohnenService = bohnenService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<Bohnen> findAll(){
        try {
            return bohnenService.findAll();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users not found");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public  void insertGenre(@Valid @RequestBody Bohnen bohnen){
        try {
            bohnenService.insert(bohnen);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = "application/json")
    public void updateGenre(@Valid @RequestBody Bohnen bohnen){
        try {
            bohnenService.updateBohnen(bohnen);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@RequestParam("id") Integer id){
        try {
            bohnenService.deleteById(id);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


}
