package fr.insa.tp.orchestratorAction;

import org.springframework.stereotype.Service;

@Service
public class OrchestratorService {

    // Méthode qui gère les fenêtres et la température
    public ActuatorState manageWindowsAndTemperature(SensorData sensorData, ActuatorState actuatorState) {
        if (sensorData.getOutdoorTemperature() < sensorData.getIndoorTemperature() && 
            sensorData.getOutdoorTemperature() >= 18 && sensorData.getOutdoorTemperature() <= 27) {
            actuatorState.setWindowOpen(true);  // Ouvrir les fenêtres
        } else {
            actuatorState.setWindowOpen(false); // Fermer les fenêtres
        }
        return actuatorState;
    }

    // Méthode qui gère les portes, fenêtres, lumières et alarmes
    public ActuatorState manageDoorsWindowsLightsAndAlarm(SensorData sensorData, ActuatorState actuatorState) {
        if (!sensorData.isPresent() && (sensorData.getTimeOfDay().compareTo("22:00") >= 0 || sensorData.getTimeOfDay().compareTo("06:00") <= 0)) {
            actuatorState.setWindowOpen(false);  // Fermer les fenêtres
            actuatorState.setDoorClosed(true);   // Fermer les portes
            actuatorState.setLightOn(false);     // Éteindre les lumières
        }

        if (sensorData.isPresent() && sensorData.getTimeOfDay().compareTo("22:00") >= 0) {
            actuatorState.setAlarmTriggered(true);  // Activer l'alarme
        } else {
            actuatorState.setAlarmTriggered(false); // Désactiver l'alarme
        }

        return actuatorState;
    }
}
