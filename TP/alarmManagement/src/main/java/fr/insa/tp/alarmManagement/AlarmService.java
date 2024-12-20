package fr.insa.tp.alarmManagement;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlarmService {

    private final List<AlarmAction> actions = new ArrayList<>();

    // Allumer ou éteindre la lumière
    public AlarmAction performAction(String action) {
        AlarmAction AlarmAction = new AlarmAction(action, LocalDateTime.now());
        actions.add(AlarmAction);
        return AlarmAction;
    }

    // Récupérer l'historique des actions
    public List<AlarmAction> getActionHistory() {
        return new ArrayList<>(actions); // Retourne une copie pour éviter les modifications directes
    }
}
