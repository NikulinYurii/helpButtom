package controller;

import com.google.gson.Gson;
import io.swagger.annotations.ResponseHeader;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import repository.MessageRepository;
import repository.UserRepository;

/**
 * Created by yurii on 22.04.17.
 */
@RestController
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
        return "Hello World!";
    }

    @RequestMapping(value = "/add_user")
    public void addUserToDb(@RequestParam(value = "gsonUser") String gsonUser) {
        User user = gson.fromJson(gsonUser, User.class);
        userRepository.save(user);
    }

    @RequestMapping(value = "/notify_users")
    public void notifyUsers(){
        
    }


}
