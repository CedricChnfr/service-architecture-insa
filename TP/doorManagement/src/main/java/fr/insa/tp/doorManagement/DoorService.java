package fr.insa.tp.doorManagement;

import org.springframework.stereotype.Service;

@Service
public class DoorService {

    private boolean isOpen = false; // Etat initial de la porte (fermée)

    // Méthode pour obtenir l'état actuel de la porte
    public String getDoorStatus() {
        return isOpen ? "Open" : "Closed";
    }

    // Méthode pour effectuer une action sur la porte (ouvrir/fermer)
    public void performAction(String action) {
        if (action.equalsIgnoreCase("OPEN")) {
            isOpen = true;
        } else if (action.equalsIgnoreCase("CLOSE")) {
            isOpen = false;
        } else {
            throw new IllegalArgumentException("Invalid action. Use 'OPEN' or 'CLOSE'.");
        }
    }
}
