package fr.insa.tp.orchestratorAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class SensorHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_window_open")
    private boolean isWindowOpen;

    @Column(name = "is_door_open")
    private boolean isDoorOpen;

    @Column(name = "is_light_on")
    private boolean isLightOn;

    @Column(name = "is_alarm_triggered")
    private boolean isAlarmTriggered;

    private LocalDateTime timestamp;

    // Constructeurs, getters et setters
    public SensorHistory(boolean isWindowOpen, boolean isDoorOpen, boolean isLightOn, boolean isAlarmTriggered, LocalDateTime timestamp) {
        this.isWindowOpen = isWindowOpen;
        this.isDoorOpen = isDoorOpen;
        this.isLightOn = isLightOn;
        this.isAlarmTriggered = isAlarmTriggered;
        this.timestamp = timestamp;
    }

    public SensorHistory() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isWindowOpen() {
        return isWindowOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        isWindowOpen = windowOpen;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public void setLightOn(boolean lightOn) {
        isLightOn = lightOn;
    }

    public boolean isAlarmTriggered() {
        return isAlarmTriggered;
    }

    public void setAlarmTriggered(boolean alarmTriggered) {
        isAlarmTriggered = alarmTriggered;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SensorHistory{" +
                "id=" + id +
                ", isWindowOpen=" + isWindowOpen +
                ", isDoorOpen=" + isDoorOpen +
                ", isLightOn=" + isLightOn +
                ", isAlarmTriggered=" + isAlarmTriggered +
                ", timestamp=" + timestamp +
                '}';
    }
}