package fr.insa.tp.orchestratorAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrchestratorService {

    @Autowired
    private RestTemplate restTemplate;

    private ActuatorState currentActuatorState = new ActuatorState(false, false, false, false);
    private List<SensorHistory> sensorHistoryList = new ArrayList<>();

    public ActuatorState manageDevices(SensorData sensorData) {
    	LocalTime currentTime = LocalTime.now();

        // Scénario 1: Ouvrir les fenêtres si la température extérieure est inférieure à la température intérieure et entre 18 et 27°
        if (sensorData.getOutdoorTemperature() < sensorData.getIndoorTemperature() &&
            sensorData.getOutdoorTemperature() >= 18 && sensorData.getOutdoorTemperature() <= 27) {
            openWindow();
        } else {
            closeWindow();
        }

        // Scénario 2: Fermer les portes, fenêtres et lumières en dehors des heures de travail si personne n'est présent
        if ((currentTime.isBefore(LocalTime.of(9, 0)) || currentTime.isAfter(LocalTime.of(18, 0))) && !sensorData.isPresenceDetected()) {
            closeDoor();
            closeWindow();
            turnOffLight();
        }

        // Scénario 3: Activer l'alarme si présence détectée après 22h
        if (sensorData.isPresenceDetected() && currentTime.isAfter(LocalTime.of(22, 0))) {
            triggerAlarm();
        } else {
            disableAlarm();
        }

        // Ajouter l'état actuel des capteurs à l'historique
        sensorHistoryList.add(new SensorHistory(
            currentActuatorState.isWindowOpen(),
            currentActuatorState.isDoorOpen(),
            currentActuatorState.isLightOn(),
            currentActuatorState.isAlarmTriggered(),
            LocalDateTime.now()
        ));

        return currentActuatorState;
    }

    public ActuatorState getCurrentActuatorState() {
        return currentActuatorState;
    }

    public List<SensorHistory> getSensorHistory() {
        return sensorHistoryList;
    }

    private void openWindow() {
        String windowServiceUrl = "http://localhost:8081/api/window?action=OPEN";
        restTemplate.postForObject(windowServiceUrl, null, String.class);
        currentActuatorState.setWindowOpen(true);
    }

    private void closeWindow() {
        String windowServiceUrl = "http://localhost:8081/api/window?action=CLOSE";
        restTemplate.postForObject(windowServiceUrl, null, String.class);
        currentActuatorState.setWindowOpen(false);
    }

    private void openDoor() {
        String doorServiceUrl = "http://localhost:8082/api/door?action=OPEN";
        restTemplate.postForObject(doorServiceUrl, null, String.class);
        currentActuatorState.setDoorOpen(false);
    }

    private void closeDoor() {
        String doorServiceUrl = "http://localhost:8082/api/door?action=CLOSE";
        restTemplate.postForObject(doorServiceUrl, null, String.class);
        currentActuatorState.setDoorOpen(true);
    }

    private void turnOnLight() {
        String lightServiceUrl = "http://localhost:8083/api/light?action=ON";
        restTemplate.postForObject(lightServiceUrl, null, String.class);
        currentActuatorState.setLightOn(true);
    }

    private void turnOffLight() {
        String lightServiceUrl = "http://localhost:8083/api/light?action=OFF";
        restTemplate.postForObject(lightServiceUrl, null, String.class);
        currentActuatorState.setLightOn(false);
    }

    private void triggerAlarm() {
        String alarmServiceUrl = "http://localhost:8084/api/alarm?action=ON";
        restTemplate.postForObject(alarmServiceUrl, null, String.class);
        currentActuatorState.setAlarmTriggered(true);
    }

    private void disableAlarm() {
        String alarmServiceUrl = "http://localhost:8084/api/alarm?action=OFF";
        restTemplate.postForObject(alarmServiceUrl, null, String.class);
        currentActuatorState.setAlarmTriggered(false);
    }
}