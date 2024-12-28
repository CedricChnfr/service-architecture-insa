package fr.insa.tp.alarmManagement;

import org.springframework.stereotype.Service;

@Service
public class AlarmService {

    private String alarmStatus = "OFF"; // État initial de l'alarme

    // Effectuer l'action sur l'alarme
    public void performAction(String action) {
        this.alarmStatus = action; // Modifie l'état de l'alarme
    }

    // Récupérer l'état actuel de l'alarme
    public String getAlarmStatus() {
        return alarmStatus; // Retourne l'état actuel de l'alarme
    }
}
