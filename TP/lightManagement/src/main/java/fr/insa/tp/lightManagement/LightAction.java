package fr.insa.tp.lightManagement;

import java.time.LocalDateTime;

public class LightAction {

    private String action;
    private LocalDateTime timestamp;

    // Constructeurs
    public LightAction(String action, LocalDateTime timestamp) {
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
