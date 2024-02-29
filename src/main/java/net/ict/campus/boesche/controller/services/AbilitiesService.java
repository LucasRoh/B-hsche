package net.ict.campus.boesche.controller.services;

import net.ict.campus.boesche.controller.repositories.AbilitiesRepository;
import net.ict.campus.boesche.model.models.Abilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AbilitiesService {
    private final AbilitiesRepository abilitiesRepository;


    public AbilitiesService(AbilitiesRepository abilitiesRepository) {
        this.abilitiesRepository = abilitiesRepository;
    }

    public Iterable<Abilities> findAll(){
        return abilitiesRepository.findAll();
    }

    public void insertAbility(Abilities abilities){
        abilitiesRepository.save(abilities);

    }

    public void updateAbility(Abilities abilities){
        abilitiesRepository.save(abilities);

    }

    public void deleteById(Integer id){
        abilitiesRepository.deleteById(id);
    }








}
