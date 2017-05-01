package controller;

import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import repository.MessageRepository;
import repository.UserRepository;

/**
 * Created by yurii on 22.04.17.
 */
@RestController
@Transactional
@RequestMapping(value = "/controller")
public class MainController {

    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public MainController(UserRepository userRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }



}
