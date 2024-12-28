package fr.insa.tp.windowsManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/window")
public class WindowController {

    @Autowired
    private WindowService windowService;

    // Endpoint pour obtenir l'état actuel de la fenêtre
    @GetMapping("/status")
    public ResponseEntity<String> getWindowStatus() {
        String status = windowService.getWindowStatus();
        return ResponseEntity.ok(status);
    }

    // Endpoint pour effectuer une action sur la fenêtre (OPEN/CLOSE)
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("OPEN") && !action.equalsIgnoreCase("CLOSE")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'OPEN' or 'CLOSE'.");
        }

        windowService.performAction(action.toUpperCase());

        // Retourne l'état actuel
        return ResponseEntity.ok(action);
    }
}
