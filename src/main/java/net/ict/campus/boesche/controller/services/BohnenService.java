package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.BohnenRepository;
import net.ict.campus.boesche.model.models.Bohnen;
import org.springframework.stereotype.Service;

@Service
public class BohnenService {
    private final BohnenRepository bohnenRepository;

    public BohnenService(BohnenRepository bohnenRepository) {
        this.bohnenRepository = bohnenRepository;
    }

    public Iterable<Bohnen> findAll(){
        return  bohnenRepository.findAll();
    }

    public void insert(Bohnen bohnen){
        bohnenRepository.save(bohnen);
    }

    public void updateBohnen(Bohnen bohnen){
        bohnenRepository.save(bohnen);
    }

    public void deleteById(Integer id){
        bohnenRepository.deleteById(id);
    }


}
