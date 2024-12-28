package fr.insa.tp.orchestratorAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orchestrator")
public class OrchestratorController {

    @Autowired
    private OrchestratorService orchestratorService;

    @GetMapping("/manage")
    public ActuatorState manageDevices(@RequestParam("presence") int presence, @RequestParam("temperature") double temperature) {
        // Créer un objet SensorData avec les valeurs récupérées
        SensorData sensorData = new SensorData(temperature, 20.0, presence == 1, "12:00");
        
        // Récupérer l'état des actionneurs basé sur les données des capteurs
        ActuatorState actuatorState = new ActuatorState(false, true, false, false); // Initialisation avec des valeurs par défaut
        actuatorState = orchestratorService.manageWindowsAndTemperature(sensorData, actuatorState);
        actuatorState = orchestratorService.manageDoorsWindowsLightsAndAlarm(sensorData, actuatorState);

        return actuatorState;
    }
}
