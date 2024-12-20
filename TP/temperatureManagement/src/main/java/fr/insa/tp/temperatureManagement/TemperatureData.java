package fr.insa.tp.temperatureManagement;

public class TemperatureData {

    private double indoorTemperature;
    private double outdoorTemperature;

    // Constructeurs
    public TemperatureData(double indoorTemperature, double outdoorTemperature) {
        this.indoorTemperature = indoorTemperature;
        this.outdoorTemperature = outdoorTemperature;
    }

    // Getters et setters
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
