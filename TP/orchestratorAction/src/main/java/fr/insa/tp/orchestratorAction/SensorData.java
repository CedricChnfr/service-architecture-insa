package fr.insa.tp.orchestratorAction;

public class SensorData {

    private double indoorTemperature;
    private double outdoorTemperature;
    private boolean presenceDetected;
    private String currentTime;

    public SensorData(double indoorTemperature, double outdoorTemperature, boolean presenceDetected, String currentTime) {
        this.indoorTemperature = indoorTemperature;
        this.outdoorTemperature = outdoorTemperature;
        this.presenceDetected = presenceDetected;
        this.currentTime = currentTime;
    }

    public double getIndoorTemperature() {
        return indoorTemperature;
    }

    public void setIndoorTemperature(double indoorTemperature) {
        this.indoorTemperature = indoorTemperature;
    }

    public double getOutdoorTemperature() {
        return outdoorTemperature;
    }

    public void setOutdoorTemperature(double outdoorTemperature) {
        this.outdoorTemperature = outdoorTemperature;
    }

    public boolean isPresenceDetected() {
        return presenceDetected;
    }

    public void setPresenceDetected(boolean presenceDetected) {
        this.presenceDetected = presenceDetected;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}