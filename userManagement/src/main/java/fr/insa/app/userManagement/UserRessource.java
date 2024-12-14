package fr.insa.app.userManagement;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRessource {

    private List<User> users = new ArrayList<>();
    private int currentId = 1;

    // Endpoint pour récupérer tous les utilisateurs
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    // Endpoint pour ajouter un nouvel utilisateur
    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        if (userDto.getRole() == null) {
            throw new IllegalArgumentException("Role must be one of the following: admin, user, volunteer.");
        }
        
        User newUser = new User(currentId++, userDto.getFirstName(), userDto.getLastName(), userDto.getRole());
        users.add(newUser);  // Ajoute l'utilisateur à la liste
        return newUser;  // Renvoie l'utilisateur créé avec l'ID
    }
}
