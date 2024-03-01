package net.ict.campus.boesche.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import net.ict.campus.boesche.controller.services.FraktionService;
import net.ict.campus.boesche.controller.services.FroescheService;
import net.ict.campus.boesche.model.models.Bohnen;
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
    @Operation(summary = "Get in Fraktion")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(
                    mediaType="application/json",
                    schema = @Schema(implementation= Fraktion.class)
            )),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest") })
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<Fraktion> findAll(){
        try{ return fraktionService.findAll();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post Fraktion by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PostMapping(consumes = "application/json")
    private void insertFraktion(@Valid @RequestBody Fraktion fraktion) {
        try {
            fraktionService.insertFraktion(fraktion);
        } catch (RuntimeException r) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Put Fraktion by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PutMapping(consumes = "application/json")
    private void updateFraktion(@Valid @RequestBody Fraktion fraktion){
        try{
            fraktionService.updateFraktion(fraktion);
        }catch(RuntimeException r){
            throw new ResponseStatusException(HttpStatus.CONFLICT);


        }
    }
    @DeleteMapping
    @Operation(summary = "Delete Fraktion by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
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


