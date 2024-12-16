package fr.insa.app.userManagement;

import org.springframework.http.ResponseEntity;
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
        User newUser = new User(currentId++, userDto.getFirstName(), userDto.getLastName(), userDto.getRole());
        users.add(newUser); // Ajoute l'utilisateur à la liste
        return newUser; // Renvoie l'utilisateur ajouté
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (removed) {
            return ResponseEntity.noContent().build(); // Suppression réussie
        } else {
            return ResponseEntity.notFound().build(); // Utilisateur introuvable
        }
    }


}
