package app.controller;

import app.repository.MessageRepository;
import app.repository.UserRepository;
import com.google.gson.Gson;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yurii on 22.04.17.
 */
@RestController
@RequestMapping("/controller")
@Transactional
public class MainController {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    Gson gson = new Gson();
    @Autowired
    public MainController(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello!";
    }

    @RequestMapping(value = "/add_user")
    public void addUserToDb(@RequestParam(value = "gsonUser") String gsonUser) {
        User user = gson.fromJson(gsonUser, User.class);
        userRepository.save(user);
    }

    @RequestMapping(value = "/notify_users")
    public void notifyUsers(){
        //todo spring web socket

    }


}
