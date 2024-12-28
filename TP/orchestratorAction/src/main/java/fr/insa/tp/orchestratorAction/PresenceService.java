package fr.insa.tp.orchestratorAction;

import org.springframework.stereotype.Service;

@Service
public class PresenceService {

    private String presenceStatus = "ABSENT"; // État initial de la présence

    // Effectuer l'action sur la présence
    public void performAction(String action) {
        this.presenceStatus = action; // Modifie l'état de la présence
    }

    // Récupérer l'état actuel de la présence
    public String getPresenceStatus() {
        return presenceStatus; // Retourne l'état actuel de la présence
    }
}
