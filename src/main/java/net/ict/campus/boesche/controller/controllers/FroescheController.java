package net.ict.campus.boesche.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@Operation(summary ="get Froesche nach ID")
@ApiResponses(value={
        @ApiResponse(responseCode = "200", description = "Froesche found" ),
        @ApiResponse(responseCode = "404", description = "Froesche notFound")
})
@RequestMapping ("/Froesche")
public class FroescheController {
    private final FroescheService froescheService;
    //Braucht kein Autowire da er ein Konstruktor hat und deshalb weiss das du der FroescheService willst
    public FroescheController(FroescheService froescheService) {
        this.froescheService = froescheService;
    }
    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public Iterable<Froesche> findAll(){
        try{
            return froescheService.findAll();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found");
        }
    }
    @GetMapping("/1")
    @ResponseStatus(HttpStatus.FOUND)
    public String getFirstFrogName(){
        try{
            return froescheService.getFirstFrogName();
        }
        catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    private void insertFroesche(@Valid @RequestBody Froesche froesche) {
        try {
            froescheService.insertFroesche(froesche);
        } catch (RuntimeException r) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User Not Found");
        }
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(consumes = "application/json")
    private void updateFroesche(@Valid @RequestBody Froesche froesche){
            try{
                froescheService.updateFroesche(froesche);
            }catch(RuntimeException r){
                throw new ResponseStatusException(HttpStatus.CONFLICT);


            }
        }
        @DeleteMapping
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
