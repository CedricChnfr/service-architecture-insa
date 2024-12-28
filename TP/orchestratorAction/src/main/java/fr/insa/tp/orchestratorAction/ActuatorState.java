package fr.insa.tp.orchestratorAction;

public class ActuatorState {

    private boolean isWindowOpen;
    private boolean isDoorClosed;
    private boolean isLightOn;
    private boolean isAlarmTriggered;

    // Constructeur
    public ActuatorState(boolean isWindowOpen, boolean isDoorClosed, boolean isLightOn, boolean isAlarmTriggered) {
        this.isWindowOpen = isWindowOpen;
        this.isDoorClosed = isDoorClosed;
        this.isLightOn = isLightOn;
        this.isAlarmTriggered = isAlarmTriggered;
    }

    // Getters et Setters
    public boolean isWindowOpen() {
        return isWindowOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        isWindowOpen = windowOpen;
    }

    public boolean isDoorClosed() {
        return isDoorClosed;
    }

    public void setDoorClosed(boolean doorClosed) {
        isDoorClosed = doorClosed;
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
}