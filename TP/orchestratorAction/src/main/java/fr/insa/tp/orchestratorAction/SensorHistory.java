package fr.insa.tp.orchestratorAction;

import java.time.LocalDateTime;

public class SensorHistory {
    private boolean isWindowOpen;
    private boolean isDoorClosed;
    private boolean isLightOn;
    private boolean isAlarmTriggered;
    private LocalDateTime timestamp;

    public SensorHistory(boolean isWindowOpen, boolean isDoorClosed, boolean isLightOn, boolean isAlarmTriggered, LocalDateTime timestamp) {
        this.isWindowOpen = isWindowOpen;
        this.isDoorClosed = isDoorClosed;
        this.isLightOn = isLightOn;
        this.isAlarmTriggered = isAlarmTriggered;
        this.timestamp = timestamp;
    }

    public boolean isWindowOpen() {
        return isWindowOpen;
    }

    public boolean isDoorClosed() {
        return isDoorClosed;
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public boolean isAlarmTriggered() {
        return isAlarmTriggered;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}