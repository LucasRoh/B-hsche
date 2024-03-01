package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.FraktionRepository;
import net.ict.campus.boesche.model.models.Fraktion;
import org.springframework.stereotype.Service;

@Service
public class FraktionService {
    private final FraktionRepository fraktionRepository;

    public FraktionService(FraktionRepository fraktionRepository) {
        this.fraktionRepository = fraktionRepository;
    }

    public Iterable<Fraktion> findAll() {
        return fraktionRepository.findAll();
    }

    public Fraktion insertFraktion(Fraktion fraktion) {
        return fraktionRepository.save(fraktion);
    }

    public void updateFraktion(Fraktion fraktion) {
        fraktionRepository.save(fraktion);
    }

    public void deleteById(Integer id) {
        fraktionRepository.deleteById(id);
    }
}


