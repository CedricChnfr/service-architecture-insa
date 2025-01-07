package fr.insa.tp.orchestratorAction;

public class ActuatorState {

    private boolean isWindowOpen;
    private boolean isDoorOpen;
    private boolean isLightOn;
    private boolean isAlarmTriggered;

    // Constructeur
    public ActuatorState(boolean isWindowOpen, boolean isDoorOpen, boolean isLightOn, boolean isAlarmTriggered) {
        this.isWindowOpen = isWindowOpen;
        this.isDoorOpen = isDoorOpen;
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
}