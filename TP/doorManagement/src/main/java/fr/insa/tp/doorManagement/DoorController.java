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
        return ResponseEntity.ok("Door is " + status);
    }

    // Endpoint pour ouvrir ou fermer la porte
    @PostMapping("/action")
    public ResponseEntity<String> controlDoor(@RequestParam String action) {
        try {
            doorService.performAction(action);
            return ResponseEntity.ok("Door is now " + action);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
