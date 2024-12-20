package fr.insa.tp.doorManagement;


import java.time.LocalDateTime;

public class DoorAction {

    private String action; 

    private LocalDateTime timestamp;

    // Constructeurs
    public DoorAction(String action, LocalDateTime timestamp) {
        this.action = action;
        this.timestamp = timestamp;
    }

    // Getters et setters
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
