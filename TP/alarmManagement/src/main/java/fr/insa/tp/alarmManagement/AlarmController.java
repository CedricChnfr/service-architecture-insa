package fr.insa.tp.alarmManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    // Endpoint pour obtenir l'état actuel de l'alarme
    @GetMapping("/status")
    public ResponseEntity<String> getAlarmStatus() {
        String status = alarmService.getAlarmStatus();
        return ResponseEntity.ok(status);
    }

    // Endpoint pour effectuer une action sur l'alarme (ON/OFF)
    @PostMapping
    public ResponseEntity<String> performAction(@RequestParam String action) {
        if (!action.equalsIgnoreCase("ON") && !action.equalsIgnoreCase("OFF")) {
            return ResponseEntity.badRequest().body("Invalid action. Use 'ON' or 'OFF'.");
        }

        alarmService.performAction(action.toUpperCase());

        // Retourne l'état actuel
        return ResponseEntity.ok(action);
    }
}
