package net.ict.campus.boesche.controller.repositories;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.ict.campus.boesche.model.models.Abilities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface AbilitiesRepository extends CrudRepository<Abilities, Integer> {

}
