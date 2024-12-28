package fr.insa.tp.doorManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/door")
public class DoorController {

    @Autowired
    private DoorService doorService;

    // Endpoint pour obtenir l'état actuel de la porte
    @GetMapping("/status")
    public ResponseEntity<String> getDoorStatus() {
        String status = doorService.getDoorStatus();
        return ResponseEntity.ok(status);
    }

    // Endpoint pour effectuer une action sur la porte (OPEN/CLOSE)
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("OPEN") && !action.equalsIgnoreCase("CLOSE")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'OPEN' or 'CLOSE'.");
        }

        doorService.performAction(action.toUpperCase());

        // Retourne l'état actuel
        return ResponseEntity.ok(action);
    }
}