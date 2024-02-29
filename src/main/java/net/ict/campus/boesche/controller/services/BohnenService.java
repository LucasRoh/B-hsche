package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.BohnenRepository;
import org.springframework.stereotype.Service;

@Service
public class BohnenService {
    private final BohnenRepository bohnenRepository;

    public BohnenService(BohnenRepository bohnenRepository) {
        this.bohnenRepository = bohnenRepository;
    }


}
