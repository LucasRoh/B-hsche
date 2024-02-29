package net.ict.campus.boesche.controller.controllers;

import net.ict.campus.boesche.controller.services.AbilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ability")
public class AbilitiesController {
    private final AbilitiesService abilitiesService;
    @Autowired
    public AbilitiesController(AbilitiesService abilitiesService) {
        this.abilitiesService = abilitiesService;
    }
}
