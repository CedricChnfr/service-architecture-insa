package fr.insa.tp.orchestratorAction;

import org.springframework.stereotype.Service;

@Service
public class WindowService {

    private String windowStatus = "CLOSED"; // État initial de la fenêtre

    // Effectuer l'action sur la fenêtre
    public void performAction(String action) {
        this.windowStatus = action; // Modifie l'état de la fenêtre
    }

    // Récupérer l'état actuel de la fenêtre
    public String getWindowStatus() {
        return windowStatus; // Retourne l'état actuel de la fenêtre
    }
}
