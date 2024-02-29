package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.FraktionRepository;
import net.ict.campus.boesche.controller.repositories.FroescheRepository;
import net.ict.campus.boesche.model.models.Fraktion;
import net.ict.campus.boesche.model.models.Froesche;

public class FroescheService {
    private final FroescheRepository froescheRepository;

    public FroescheService(FroescheRepository froescheRepository) {
        this.froescheRepository = froescheRepository;
    }
    public FroescheService(FroescheRepository froescheRepository) {
        this.froescheRepository = froescheRepository;
    }
    public Iterable<Froesche> findall()
    {return FroescheRepository.findall();}
    public void insertFroesche(Froesche froesche){
        return FroescheRepository.insertFroesche.save(froesche);
    }
    public void updateFroesche(Froesche froesche){
        return FroescheRepository.updateFroesche.save(froesche);
    }
    public void deleteById(Integer id){
        return FroescheRepository.deleteById(id);
    }
}
