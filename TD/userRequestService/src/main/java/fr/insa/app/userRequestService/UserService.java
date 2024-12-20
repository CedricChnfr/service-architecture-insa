package fr.insa.app.userRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    // URL du microservice 8090
    private final String USERS_API_URL = "http://localhost:8090/users";

    // Méthode pour récupérer les utilisateurs depuis le microservice 8090
    public List<User> getUsers() {
        // Effectuer la requête GET vers localhost:8090/users
        User[] usersArray = restTemplate.getForObject(USERS_API_URL, User[].class);
        return List.of(usersArray); // Convertit l'array en liste
    }
}
