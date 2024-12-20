package fr.insa.tp.windowsManagement;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WindowService {

    private final List<WindowAction> actions = new ArrayList<>();

    // Effectuer une action sur une fenêtre
    public WindowAction performAction(String action) {
        WindowAction windowAction = new WindowAction(action, LocalDateTime.now());
        actions.add(windowAction);
        return windowAction;
    }

    // Récupérer l'historique des actions
    public List<WindowAction> getActionHistory() {
        return new ArrayList<>(actions); // Retourne une copie pour éviter les modifications directes
    }
}
