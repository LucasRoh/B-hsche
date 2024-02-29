package net.ict.campus.boesche.controller.controllers;

import net.ict.campus.boesche.controller.services.BohnenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ability")
public class BohnenController {
    //Bohnenservice wird aufgerufen um auf die Methoden zuzugreifen
    private final BohnenService bohnenService;

    @Autowired
    public BohnenController(BohnenService bohnenService) {
        this.bohnenService = bohnenService;
    }

}
