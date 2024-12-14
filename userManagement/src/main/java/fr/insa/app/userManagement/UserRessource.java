package fr.insa.app.userManagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRessource {

    @GetMapping("/users")
    public int userCount() {
        return 100; // Exemple : retourne un nombre fixe d'utilisateurs
    }

    @GetMapping(value = "/users/{id}")
    public User getUserInfo(@PathVariable int id) {
        // Exemple : retourne un utilisateur avec des informations fictives
        return new User(id, "Cedric", "Chanfreau");
    }
}
