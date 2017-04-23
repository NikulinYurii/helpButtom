package utils;

import model.Message;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import repository.Dao;

import java.util.List;

/**
 * Created by yurii on 23.04.17.
 */
public class Utils {

    @Autowired
    private Dao dao;

    public void notifyUsers(Message message){
        List<User> users = dao.findByAddress_City(message.getAddress().getCity());

    }


}
