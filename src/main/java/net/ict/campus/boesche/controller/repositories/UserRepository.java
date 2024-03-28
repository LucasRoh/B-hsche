package net.ict.campus.boesche.controller.repositories;

import net.ict.campus.boesche.model.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    //User Methode die auf der Db ein Select User from username where username = @Param;//


    User findByUsername(@Param("username") String var1);
}
