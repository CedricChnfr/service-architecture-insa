package fr.insa.tp.lightManagement;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LightService {

    private final List<LightAction> actions = new ArrayList<>();

    // Allumer ou éteindre la lumière
    public LightAction performAction(String action) {
        LightAction lightAction = new LightAction(action, LocalDateTime.now());
        actions.add(lightAction);
        return lightAction;
    }

    // Récupérer l'historique des actions
    public List<LightAction> getActionHistory() {
        return new ArrayList<>(actions); // Retourne une copie pour éviter les modifications directes
    }
}
