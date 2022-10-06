package fr.industryportal.ontomapper.controller;

import fr.industryportal.ontomapper.model.entities.User;
import fr.industryportal.ontomapper.model.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Abdelwadoud Rasmi
 * Controller to manage users
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * get all users
     */
    @RequestMapping("")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * Add a user to db
     */
    @PostMapping("")
    public void addUser(@RequestParam String id,
                        @RequestParam String label) {

        userRepository.save(new User(id, label, null));

    }

}
