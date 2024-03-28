package net.ict.campus.boesche.controller.repositories;

import net.ict.campus.boesche.model.models.Froesche;
import net.ict.campus.boesche.model.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FroescheRepository extends CrudRepository<Froesche, Integer>{

}
