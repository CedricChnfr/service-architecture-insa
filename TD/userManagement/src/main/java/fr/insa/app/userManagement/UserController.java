package fr.insa.app.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) {
        System.out.println("Received user: " + userDto);  // Vérifiez les données reçues

        // Créez un nouvel utilisateur avec les données reçues
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(userDto.getRole());

        // Sauvegardez l'utilisateur dans la base de données
        User savedUser = userService.addUser(user);

        // Vérifiez si l'utilisateur a été ajouté
        System.out.println("User saved: " + savedUser);
        
        return savedUser;
    }



    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
