package fr.insa.tp.windowsManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/window")
public class WindowController {

    @Autowired
    private WindowService windowService;

    // Endpoint pour effectuer une action
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("OPEN") && !action.equalsIgnoreCase("CLOSE")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'OPEN' or 'CLOSE'.");
        }

        WindowAction windowAction = windowService.performAction(action.toUpperCase());

        // Affiche le temps dans les logs (côté serveur)
        System.out.println("Action performed: " + windowAction.getAction() + " at " + windowAction.getTimestamp());

        // Retourne uniquement l'action
        return ResponseEntity.ok(windowAction.getAction());
    }

    // Endpoint pour récupérer l'historique des actions
    @GetMapping("/history")
    public List<String> getActionHistory() {
        return windowService.getActionHistory().stream()
                .map(windowAction -> "Action: " + windowAction.getAction() + ", Performed at: " + windowAction.getTimestamp())
                .collect(Collectors.toList());
    }
}
