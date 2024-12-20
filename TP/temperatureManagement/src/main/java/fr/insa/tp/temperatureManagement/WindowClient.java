package fr.insa.tp.temperatureManagement;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WindowClient {

    private static final String WINDOW_API_URL = "http://localhost:8081/api/window";

    private final RestTemplate restTemplate = new RestTemplate();

    public void openWindow() {
        try {
            restTemplate.postForEntity(WINDOW_API_URL + "?action=OPEN", null, String.class);
            System.out.println("Window opened via WindowManagementService.");
        } catch (Exception e) {
            System.err.println("Failed to open window: " + e.getMessage());
        }
    }
 
    public void closeWindow() {
        try {
            restTemplate.postForEntity(WINDOW_API_URL + "?action=CLOSE", null, String.class);
            System.out.println("Window closed via WindowManagementService.");
        } catch (Exception e) {
            System.err.println("Failed to close window: " + e.getMessage());
        }
    }
}
