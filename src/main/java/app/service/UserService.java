package app.service;

import app.model.Address;
import app.model.User;
import app.repository.MessageRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yurii on 20.05.17.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserExist(User user) {

        boolean isExist =
                userRepository.findOne(user.getId()) != null ? true : false;

        return isExist;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findOne(id);
    }

    public void updateUser(User currentUser) {
        userRepository.delete(currentUser.getId());
        userRepository.save(currentUser);
    }

    public List<User> findByAddress(Address address){
        List<User> userList = userRepository.findByAddress_City(address.getCity());
        return userList;
    }
}
