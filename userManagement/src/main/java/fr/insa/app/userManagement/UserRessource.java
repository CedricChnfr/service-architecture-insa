package fr.insa.app.userManagement;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRessource {

    // Liste pour stocker temporairement les utilisateurs (en mémoire)
    private List<User> users = new ArrayList<>();
    private int currentId = 1;

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    // Ajouter un nouvel utilisateur
    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        User newUser = new User(currentId++, userDto.getFirstName(), userDto.getLastName(), userDto.getRole());
        users.add(newUser);
        return newUser;
    }
}
