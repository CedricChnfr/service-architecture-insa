package fr.insa.tp.alarmManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    // Endpoint pour effectuer une action
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("ON") && !action.equalsIgnoreCase("OFF")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'ON' or 'OFF'.");
        }

        AlarmAction alarmAction = alarmService.performAction(action.toUpperCase());

        // Affiche le temps dans les logs (côté serveur)
        System.out.println("alarm action performed: " + alarmAction.getAction() + " at " + alarmAction.getTimestamp());

        // Retourne uniquement l'action
        return ResponseEntity.ok(alarmAction.getAction());
    }

    // Endpoint pour récupérer l'historique des actions
    @GetMapping("/history")
    public List<String> getActionHistory() {
        return alarmService.getActionHistory().stream()
                .map(alarmAction -> "Action: " + alarmAction.getAction() + ", Performed at: " + alarmAction.getTimestamp())
                .collect(Collectors.toList());
    }
}
