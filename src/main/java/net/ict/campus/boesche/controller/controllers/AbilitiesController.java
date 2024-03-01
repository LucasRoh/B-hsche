package net.ict.campus.boesche.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import net.ict.campus.boesche.controller.services.AbilitiesService;
import net.ict.campus.boesche.model.models.Abilities;
import net.ict.campus.boesche.model.models.Bohnen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/ability")
public class AbilitiesController {
    private final AbilitiesService abilitiesService;
    @Autowired
    public AbilitiesController(AbilitiesService abilitiesService) {
        this.abilitiesService = abilitiesService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<Abilities> findAll(){
        try {
            return abilitiesService.findAll();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users not found");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void insertAbility(@Valid @RequestBody Abilities abilities){
        try {
            abilitiesService.insertAbility(abilities);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = "application/json")
    public void updateAbility(@Valid @RequestBody Abilities abilities){
        try {
            abilitiesService.updateAbility(abilities);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteById(@RequestParam("id") Integer id){
        try {
            abilitiesService.deleteById(id);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }









}
