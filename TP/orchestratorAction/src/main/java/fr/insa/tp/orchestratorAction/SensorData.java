package fr.insa.tp.orchestratorAction;

public class SensorData {

    private double indoorTemperature;
    private double outdoorTemperature;
    private boolean isPresent;  // Indique si une personne est présente
    private String timeOfDay;  // Heure actuelle (ex. "22:00")

    // Constructeur
    public SensorData(double indoorTemperature, double outdoorTemperature, boolean isPresent, String timeOfDay) {
        this.indoorTemperature = indoorTemperature;
        this.outdoorTemperature = outdoorTemperature;
        this.isPresent = isPresent;
        this.timeOfDay = timeOfDay;
    }

    // Getters et Setters
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

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }
}
