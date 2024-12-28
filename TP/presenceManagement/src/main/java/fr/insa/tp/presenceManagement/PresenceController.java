package fr.insa.tp.presenceManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presence")
public class PresenceController {

    @Autowired
    private PresenceService presenceService;

    // Endpoint pour obtenir l'état actuel de la présence
    @GetMapping("/status")
    public ResponseEntity<String> getPresenceStatus() {
        String status = presenceService.getPresenceStatus();
        return ResponseEntity.ok(status);
    }

    // Endpoint pour effectuer une action sur la présence (PRESENT/ABSENT)
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("PRESENT") && !action.equalsIgnoreCase("ABSENT")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'PRESENT' or 'ABSENT'.");
        }

        presenceService.performAction(action.toUpperCase());

        // Retourne l'état actuel
        return ResponseEntity.ok(action);
    }
}
