package app.repository;

import app.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yurii on 22.04.17.
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByAddress_City(String city);

}
