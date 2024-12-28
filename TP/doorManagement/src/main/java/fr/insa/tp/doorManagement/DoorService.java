package fr.insa.tp.doorManagement;

import org.springframework.stereotype.Service;

@Service
public class DoorService {

    private String doorStatus = "CLOSED"; // État initial de la porte

    // Effectuer l'action sur la porte
    public void performAction(String action) {
        this.doorStatus = action; // Modifie l'état de la porte
    }

    // Récupérer l'état actuel de la porte
    public String getDoorStatus() {
        return doorStatus; // Retourne l'état actuel de la porte
    }
}