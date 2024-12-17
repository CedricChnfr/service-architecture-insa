package fr.insa.app.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        // Vérifiez si la sauvegarde dans la base de données est effectuée
        System.out.println("Saving user: " + user);
        return userRepository.save(user);  // Sauvegarde dans la base de données
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
