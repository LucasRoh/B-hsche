package net.ict.campus.boesche.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import net.ict.campus.boesche.controller.services.BohnenService;
import net.ict.campus.boesche.model.models.Bohnen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/bohnen")
public class BohnenController {
    //Bohnenservice wird aufgerufen um auf die Methoden zuzugreifen
    private final BohnenService bohnenService;

    @Autowired
    public BohnenController(BohnenService bohnenService) {
        this.bohnenService = bohnenService;
    }

    @GetMapping
    @Operation(summary = "Get in Bohnen")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(
                    mediaType="application/json",
                    schema = @Schema(implementation=Bohnen.class)
            )),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest") })
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
    @Operation(summary = "Post Bohnen by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })


        @PostMapping(consumes = "application/json")
    public  void insertBohnen(@Valid @RequestBody Bohnen bohnen){
        try {
            bohnenService.insert(bohnen);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Conflict");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Put Bohnen by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
    @PutMapping(consumes = "application/json")
    public void updateBohnen(@Valid @RequestBody Bohnen bohnen){
        try {
            bohnenService.updateBohnen(bohnen);
        }
        catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }
    @DeleteMapping
    @Operation(summary = "Delete Bohnen by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")})
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
