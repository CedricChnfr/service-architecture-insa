package fr.insa.tp.temperatureManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    @Autowired
    private WindowClient windowClient;

    // Vérifier la température et prendre une décision
    public String analyzeTemperature(TemperatureData temperatureData) {
        double indoorTemp = temperatureData.getIndoorTemperature();
        double outdoorTemp = temperatureData.getOutdoorTemperature();

        // Logique métier : ouvrir les fenêtres si les conditions sont remplies
        if (outdoorTemp < indoorTemp && outdoorTemp >= 18 && outdoorTemp <= 27) {
            windowClient.openWindow();
            return "Conditions met: Windows opened.";
        } else {
        	windowClient.closeWindow();
            return "Conditions met: Windows closed.";
        }
    }
}
