package fr.insa.tp.lightManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/light")
public class LightController {

    @Autowired
    private LightService lightService;

    // Endpoint pour effectuer une action
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("ON") && !action.equalsIgnoreCase("OFF")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'ON' or 'OFF'.");
        }

        LightAction lightAction = lightService.performAction(action.toUpperCase());

        // Affiche le temps dans les logs (côté serveur)
        System.out.println("Light action performed: " + lightAction.getAction() + " at " + lightAction.getTimestamp());

        // Retourne uniquement l'action
        return ResponseEntity.ok(lightAction.getAction());
    }

    // Endpoint pour récupérer l'historique des actions
    @GetMapping("/history")
    public List<String> getActionHistory() {
        return lightService.getActionHistory().stream()
                .map(lightAction -> "Action: " + lightAction.getAction() + ", Performed at: " + lightAction.getTimestamp())
                .collect(Collectors.toList());
    }
}

