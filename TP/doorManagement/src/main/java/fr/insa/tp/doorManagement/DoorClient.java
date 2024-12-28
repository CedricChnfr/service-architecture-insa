package fr.insa.tp.doorManagement;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorClient {

    private static final String DOOR_API_URL = "http://localhost:8082/api/door";

    private final RestTemplate restTemplate = new RestTemplate();

    public void openDoor() {
        try {
            restTemplate.postForEntity(DOOR_API_URL + "?action=OPEN", null, String.class);
            System.out.println("Door opened via DoorManagementService.");
        } catch (Exception e) {
            System.err.println("Failed to open door: " + e.getMessage());
        }
    }

    public void closeDoor() {
        try {
            restTemplate.postForEntity(DOOR_API_URL + "?action=CLOSE", null, String.class);
            System.out.println("Door closed via DoorManagementService.");
        } catch (Exception e) {
            System.err.println("Failed to close door: " + e.getMessage());
        }
    }
}