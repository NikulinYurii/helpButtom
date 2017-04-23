package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.Dao;

/**
 * Created by yurii on 22.04.17.
 */
@RestController
@Transactional
@RequestMapping("/help_buttom_service")
public class MainController {

    private final Dao dao;

    @Autowired
    public MainController(Dao dao) {
        this.dao = dao;
    }


}
