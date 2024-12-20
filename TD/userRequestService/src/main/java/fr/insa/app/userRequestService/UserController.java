package fr.insa.app.userRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint pour récupérer tous les utilisateurs
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
