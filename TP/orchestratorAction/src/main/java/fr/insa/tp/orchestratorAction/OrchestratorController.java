package fr.insa.tp.orchestratorAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orchestrator")
public class OrchestratorController {

    @Autowired
    private OrchestratorService orchestratorService;

    @PostMapping("/manage")
    public ActuatorState manageDevices(@RequestBody SensorData sensorData) {
        return orchestratorService.manageDevices(sensorData);
    }

    @GetMapping("/status")
    public ActuatorState getDeviceStatus() {
        return orchestratorService.getCurrentActuatorState();
    }

    @GetMapping("/history")
    public List<SensorHistory> getSensorHistory() {
        return orchestratorService.getSensorHistory();
    }
}