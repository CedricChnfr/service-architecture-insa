package fr.insa.tp.doorManagement;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoorService {

    private final List<DoorAction> actions = new ArrayList<>();

    // Effectuer une action sur la porte
    public DoorAction performAction(String action) {
        DoorAction doorAction = new DoorAction(action, LocalDateTime.now());
        actions.add(doorAction);
        return doorAction;
    }

    // Récupérer l'historique des actions
    public List<DoorAction> getActionHistory() {
        return new ArrayList<>(actions); // Retourne une copie pour éviter les modifications directes
    }
}
