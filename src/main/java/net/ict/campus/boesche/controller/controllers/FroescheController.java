package net.ict.campus.boesche.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping ("/froesche")
public class FroescheController {
    private final FroescheService froescheService;
    //Braucht kein Autowire da er ein Konstruktor hat und deshalb weiss das du der FroescheService willst
    public FroescheController(FroescheService froescheService) {
        this.froescheService = froescheService;
    }
    @GetMapping
    @Operation(summary = "Get in Froesche")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(
                    mediaType="application/json",
                    schema = @Schema(implementation= Froesche.class)
            )),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest") })
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<Froesche> findAll(){
        try{
            return froescheService.findAll();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post Froesche by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
    @PostMapping(consumes = "application/json")
    private void insertFroesche(@Valid @RequestBody Froesche froesche) {
        try {
            froescheService.insertFroesche(froesche);
        } catch (RuntimeException r) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)

    @Operation(summary = "Put Froesche by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
    @PutMapping(consumes = "application/json")
    private void updateFroesche(@Valid @RequestBody Froesche froesche){
            try{
                froescheService.updateFroesche(froesche);
            }catch(RuntimeException r){
                throw new ResponseStatusException(HttpStatus.CONFLICT);


            }
        }
        @DeleteMapping

        @Operation(summary = "Delete Froesche by ID")
        @ApiResponses(value={
                @ApiResponse(responseCode = "200", description = "Ok"),
                @ApiResponse(responseCode = "404", description = "NotFound"),
                @ApiResponse(responseCode = "401", description = "Unauthorized"),
                @ApiResponse(responseCode = "403", description = "Forbidden"),
                @ApiResponse(responseCode = "400", description = "BadRequest")
        })
        @ResponseStatus(HttpStatus.ACCEPTED)
        public void deleteById(@RequestParam("Id") Integer id){
        try {
            froescheService.deleteById(id);
        }catch(RuntimeException r){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
        //Valid schaut ob der user import clean ist//


}
