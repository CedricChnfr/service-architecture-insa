package fr.insa.tp.doorManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/door")
public class DoorController {

    @Autowired
    private DoorService doorService;

    // Endpoint pour effectuer une action
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("OPEN") && !action.equalsIgnoreCase("CLOSE")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'OPEN' or 'CLOSE'.");
        }

        DoorAction doorAction = doorService.performAction(action.toUpperCase());

        // Affiche le temps dans les logs (côté serveur)
        System.out.println("Action performed: " + doorAction.getAction() + " at " + doorAction.getTimestamp());

        // Retourne uniquement l'action
        return ResponseEntity.ok(doorAction.getAction());
    }

    // Endpoint pour récupérer l'historique des actions
    @GetMapping("/history")
    public List<String> getActionHistory() {
        return doorService.getActionHistory().stream()
                .map(doorAction -> "Action: " + doorAction.getAction() + ", Performed at: " + doorAction.getTimestamp())
                .collect(Collectors.toList());
    }
}
