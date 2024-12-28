package fr.insa.tp.lightManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/light")
public class LightController {

    @Autowired
    private LightService lightService;

    // Endpoint pour obtenir l'état actuel de la lumière
    @GetMapping("/status")
    public ResponseEntity<String> getLightStatus() {
        String status = lightService.getLightStatus();
        return ResponseEntity.ok(status);
    }

    // Endpoint pour effectuer une action sur la lumière (ON/OFF)
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("ON") && !action.equalsIgnoreCase("OFF")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'ON' or 'OFF'.");
        }

        lightService.performAction(action.toUpperCase());

        // Retourne l'état actuel
        return ResponseEntity.ok(action);
    }
}
