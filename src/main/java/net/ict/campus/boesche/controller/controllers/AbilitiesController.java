package net.ict.campus.boesche.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get in Abilities")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(
                    mediaType="application/json",
                    schema = @Schema(implementation=Abilities.class)
            )),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest") })
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
    @Operation(summary = "Post Abilities by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
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
    @Operation(summary = "Put Abilities by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
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
    @Operation(summary = "Delete Abilities by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
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
