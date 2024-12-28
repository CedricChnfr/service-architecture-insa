package fr.insa.tp.orchestratorAction;

public class TemperatureData {

    private double indoorTemperature;
    private double outdoorTemperature;

    // Constructeur
    public TemperatureData(double indoorTemperature, double outdoorTemperature) {
        this.indoorTemperature = indoorTemperature;
        this.outdoorTemperature = outdoorTemperature;
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
}
