package repository;

import model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yurii on 24.04.17.
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, String> {

}
