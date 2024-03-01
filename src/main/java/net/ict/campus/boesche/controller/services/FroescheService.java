package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.FraktionRepository;
import net.ict.campus.boesche.controller.repositories.FroescheRepository;
import net.ict.campus.boesche.model.models.Fraktion;
import net.ict.campus.boesche.model.models.Froesche;
import org.springframework.stereotype.Service;

@Service
public class FroescheService {
    private final FroescheRepository froescheRepository;

    public FroescheService(FroescheRepository froescheRepository) {
        this.froescheRepository = froescheRepository;
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
