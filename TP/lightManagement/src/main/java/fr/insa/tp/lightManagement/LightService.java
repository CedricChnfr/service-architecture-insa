package fr.insa.tp.lightManagement;

import org.springframework.stereotype.Service;

@Service
public class LightService {

    private String lightStatus = "OFF"; // État initial de la lumière

    // Effectuer l'action sur la lumière
    public void performAction(String action) {
        this.lightStatus = action; // Modifie l'état de la lumière
    }

    // Récupérer l'état actuel de la lumière
    public String getLightStatus() {
        return lightStatus; // Retourne l'état actuel de la lumière
    }
}
