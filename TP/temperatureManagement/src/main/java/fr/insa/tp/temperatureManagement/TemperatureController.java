package fr.insa.tp.temperatureManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    // Endpoint pour récupérer les températures intérieure et extérieure
    @GetMapping("/status")
    public ResponseEntity<TemperatureData> getTemperatureStatus() {
        TemperatureData temperatureData = temperatureService.getTemperatureData();
        return ResponseEntity.ok(temperatureData);
    }
}
