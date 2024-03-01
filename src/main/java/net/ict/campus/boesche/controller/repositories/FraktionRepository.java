package net.ict.campus.boesche.controller.repositories;

import net.ict.campus.boesche.model.models.Fraktion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraktionRepository extends CrudRepository<Fraktion, Integer> {
}
