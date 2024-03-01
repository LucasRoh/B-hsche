package net.ict.campus.boesche.controller.repositories;

import net.ict.campus.boesche.model.models.Bohnen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BohnenRepository extends CrudRepository<Bohnen, Integer> {
}
