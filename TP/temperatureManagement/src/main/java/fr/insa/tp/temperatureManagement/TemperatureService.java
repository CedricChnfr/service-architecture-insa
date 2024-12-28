package fr.insa.tp.temperatureManagement;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    // Simuler des valeurs de température pour l'exemple
    private double indoorTemperature = 22.5; // Température intérieure en °C
    private double outdoorTemperature = 15.0; // Température extérieure en °C

    // Méthode pour récupérer les données de température
    public TemperatureData getTemperatureData() {
        return new TemperatureData(indoorTemperature, outdoorTemperature);
    }

    // Méthode pour mettre à jour la température intérieure et extérieure (si nécessaire)
    public void updateTemperatures(double indoor, double outdoor) {
        this.indoorTemperature = indoor;
        this.outdoorTemperature = outdoor;
    }
}
