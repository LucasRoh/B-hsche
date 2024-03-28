package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.FraktionRepository;
import net.ict.campus.boesche.controller.repositories.FroescheRepository;
import net.ict.campus.boesche.model.models.Fraktion;
import net.ict.campus.boesche.model.models.Froesche;
import net.ict.campus.boesche.model.models.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class FroescheService {
    private final FroescheRepository froescheRepository;

    public FroescheService(FroescheRepository froescheRepository) {
        this.froescheRepository = froescheRepository;
    }
    public Froesche findById(Integer id){
        Optional<Froesche> frosch = froescheRepository.findById(id);
        return frosch.orElseThrow(EntityNotFoundException::new);
    }
    public Iterable<Froesche> findAll() {
        return froescheRepository.findAll();
    }
    public void insertFroesche(Froesche froesche){
        froescheRepository.save(froesche);
    }
    public void updateFroesche(Froesche froesche){
        froescheRepository.save(froesche);
    }
    public void deleteById(Integer id){
        froescheRepository.deleteById(id);
    }

    public String getFirstFrogName() {
        return "Blabla";
    }
}
