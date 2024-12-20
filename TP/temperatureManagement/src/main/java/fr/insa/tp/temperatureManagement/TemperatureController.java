package fr.insa.tp.temperatureManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/temperature")
public class TemperatureController {

    @Autowired
    private TemperatureService temperatureService;

    // Endpoint pour analyser la température
    @PostMapping("/analyze")
    public ResponseEntity<String> analyzeTemperature(@RequestBody TemperatureData temperatureData) {
        String result = temperatureService.analyzeTemperature(temperatureData);
        return ResponseEntity.ok(result);
    }
}
